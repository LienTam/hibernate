package timkiemdiadiemamthuc.model;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.Session;
import org.hibernate.Transaction;

@Entity
public class Contract {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private boolean checks ;// dùng thử
	private Calendar startDate;
	private Calendar endDate;
	private int expiryTime;// hạn sử dụng tinh theo thang
	private boolean vip;
	private int location;// vi tri dat quang cao
	@OneToMany(mappedBy= "contract")
	private Set<Commercial> listCommercials;
	// location = 1 dau trang, location = 0 xuat hien thong thuong, location =2 google map
	public Contract(Boolean check, int expiryTime, boolean vip, int location ) {
		this.checks = check;
		this.startDate = Calendar.getInstance();
		if (check = true) {
			this.vip = false;
			this.location =0;
			expiryTime = 1;
		}
		else {
			this.vip = vip;
			this.location = location;
			this.expiryTime = expiryTime;
		}
		
		int yearEndDate = this.startDate.get(Calendar.YEAR);
		int monthEndDate = this.startDate.get(Calendar.MONTH)+1+expiryTime;
		int dayEndDate = this.startDate.get(Calendar.DAY_OF_MONTH);
		if (monthEndDate>=13) {
			monthEndDate = monthEndDate-12;
			yearEndDate +=1;
		}
		this.endDate = Calendar.getInstance();
		this.endDate.set(yearEndDate, monthEndDate, dayEndDate);
		
	}

	public boolean isChecks() {
		return checks;
	}

	public void setChecks(boolean checks) {
		this.checks = checks;
	}

	public int getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(int expiryTime) {
		this.expiryTime = expiryTime;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

	public int getId() {
		return id;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}
	

public static void main(String[] args) {
	Session session = HibernateUtil.openSession();
	Transaction trans = null;
	try{
		trans = session.beginTransaction();
			Contract contract = new Contract(true, 1, true, 1);
			session.persist(contract);
			trans.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		if (trans!=null) {
			trans.rollback();
		}
		}
}
	

}
