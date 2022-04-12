import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileManager {
	private static FileManager instance = null;
	
	private String filename;
	
	private FileManager() {
		System.out.println("constructing FileManager");
		filename = "data.dat";
	}
	// ------------------------------------------------------------- get/set methods
	public void setFilename(String value) {
		filename = value;
	}
	
	// ------------------------------------------------------------- public methods
	public void save(Object object) {
		System.out.println("save");

		try {
			File file = new File(filename);
			FileOutputStream fileStream = new FileOutputStream(file);
			ObjectOutputStream dataStream = new ObjectOutputStream(fileStream);
			dataStream.writeObject(object);
			dataStream.close();
		} catch (Exception e) {
			System.out.println("Binary file output error:" + e.getMessage());
		}
	}
	

	public Object load() {
		System.out.println("load");
		
		try {
			File file = new File(filename);
			if (file.exists()) {
				FileInputStream fileStream = new FileInputStream(file);
				ObjectInputStream dataStream = new ObjectInputStream(fileStream);
				Object object = (Account) dataStream.readObject();
				dataStream.close();
				
				return object;
			}else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("Binary file output error:" + e.getMessage());
			return null;
		}

	}
	
	// ------------------------------------------------------------- class methods
	// the class method allow to access it globally
	public static FileManager getInstance() {
		// instance == null make sure it is only constructed once
		if (instance == null) {
			instance = new FileManager();
		}
		return instance;
	}
}

