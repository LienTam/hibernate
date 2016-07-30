package timkiemdiadiemamthuc.model;

import javax.transaction.SystemException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestDiaDiemAmThuc {

	public static void main(String[] args) throws IllegalStateException, SystemException {
		Session session = HibernateUtil.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			Address address = new Address("28/2C1 Đường 10 Linh Trung Thủ Đức TP Hồ Chí Minh");
			String adresLienTam = "Tân Lý 2, Tân Bình , LaGi, Bình Thuận";
			session.persist(address);

			Account lienTam = new Admin("LienTam", "lientam95", "lientam110995@gmail.com", "Phan Thị Ngọc Tâm", false,
					adresLienTam);
			Admin admin = (Admin) lienTam;
			Account thanhTam = new User("Thanh Tâm", "12345", "heocondethuong@gmail.com", "Nguyễn Thanh Tâm", true,
					"Bình An 1, Tân Bình LaGi Bình Thuận");
			
			session.persist(lienTam);
			Account thanhTam3 = new Partnet("Thanh Tâm", "12345", "heocondethuong@gmail.com", "Nguyễn Thanh Tâm", true,
					"Bình An 1, Tân Bình LaGi Bình Thuận", "Nhà Hàng Thuận Thảo");
			Partnet partnet = (Partnet) thanhTam3;
			session.persist(lienTam);
			session.persist(thanhTam);
			session.persist(thanhTam3);
			
			Contract contract = new Contract(true,  3, true, 1);
			session.persist(contract);
			
			Commercial commercial = new Commercial(partnet, admin, 2,  5000000, contract);
			session.persist(commercial);
			
			
			Post post1 = new Post("Thiên Đường Món Gà Tươi Đủ Loại Sốt Tại Sài Gòn, Ở Đâu?",
					"Địa điểm lần này tôi chọn khám phá là chi nhánh của Papa’s Chicken "
							+ "trên mặt tiền đường Cách Mạng Tháng Tám. Đẹp, rộng rãi, bắt mắt,"
							+ " không có cảm giác ngột ngạt, đó là những cảm giác đầu tiên "
							+ "khi tôi đặt chân vào nơi này. Mùi thơm sực nức của những món bàn bên đang dùng,"
							+ " tiếng cười, tiếng muỗng nĩa chan chát trên dĩa gợi cho tôi một cảm giác vừa vui vẻ,"
							+ " vừa có sự tươi trẻ trong nhà hàng này.Thông thường,"
							+ " khách đến đây có thể dạo một vòng để có thể chọn cho mình một không gian vừa ý."
							+ " Ví dụ, ở tầng trệt thì được làm theo kiểu không gian đơn giản,"
							+ " rộng rãi và có tính kết nối thì ở tầng trên lại có tính riêng tư hơn với hai khu:"
							+ " “Khu nhà máy” Papa’s và “Khu hiện đại” với góc nhìn đẹp hướng xuống mặt đường."
							+ " Cả hai khu này đều được trang trí bắt mắt, thích hợp cho những bạn nào thích selfie nha!"
							+ " Thậm chí, có một khu vực với những vách ngăn dựng cao hẳn lên, nhóm của bạn có thể chọn ngồi trong này,"
							+ " vừa có tính riêng tư, nhưng cũng không bị cách biệt nhé. "
							+ "Nhân viên của Papa’s sẽ hỗ trợ bạn tận tình cho bạn tìm được một chỗ ngồi yêu thích đó. ",
					lienTam,  address,admin,commercial);
			session.persist(post1);
			
			Guide guide = new Guide("hướng dẫn abc", admin);
			session.persist(guide);

			Image image = new Image("motCongMotBangHai", post1);
			session.persist(image);

			Likes lienTamLike = new Likes(post1);
			session.persist(lienTamLike);

			Share lienTamShare = new Share(post1);
			session.persist(lienTamShare);

			Comment lienTamCmt = new Comment("Ngon", post1);
			session.persist(lienTamCmt);

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}
}
