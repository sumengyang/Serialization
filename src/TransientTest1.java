import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @description 
 * ʹ��transient�ؼ��ֲ����л�ĳ������ 
 * ע���ȡ��ʱ�򣬶�ȡ���ݵ�˳��һ��Ҫ�ʹ�����ݵ�˳�򱣳�һ��
 */
public class TransientTest1 {
	public static void main(String[] args) {

		User2 user = new User2();
		user.setUsername("Alexia");
		user.setPasswd("123456");

		System.out.println("read before Serializable: ");
		System.out.println("username: " + user.getUsername());
		System.err.println("password: " + user.getPasswd());

		try {
			ObjectOutputStream os = new ObjectOutputStream(
					new FileOutputStream("C:/user.txt"));
			os.writeObject(user); // ��User����д���ļ�
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(
					"C:/user.txt"));
			user = (User2) is.readObject(); // �����ж�ȡUser������
			is.close();

			System.out.println("\nread after Serializable: ");
			System.out.println("username: " + user.getUsername());
			System.err.println("password: " + user.getPasswd());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class User1 implements Serializable {
	private static final long serialVersionUID = 8294180014912103005L;

	private String username;
	private transient String passwd;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}