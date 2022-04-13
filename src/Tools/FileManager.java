package Tools;
import Accounts.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

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
	public void save(List<Object> objectlist) {
		System.out.println("save");

		try {
			File file = new File(filename);
			FileOutputStream fileStream = new FileOutputStream(file);
			ObjectOutputStream dataStream = new ObjectOutputStream(fileStream);
			// write the object list into the datastream
			dataStream.writeObject(objectlist);
			System.out.println(objectlist);
			dataStream.close();
		} catch (Exception e) {
			System.out.println("Binary file input error:" + e.getMessage());
		}
	}
	

	public Object load() {
		System.out.println("load");
		
		try {
			File file = new File(filename);
			if (file.exists()) {
				FileInputStream fileStream = new FileInputStream(file);
				ObjectInputStream dataStream = new ObjectInputStream(fileStream);
				// converting the List<Object> to List<Account>
				List<Account> objectlist = (List<Account>) dataStream.readObject();
				dataStream.close();
				System.out.println(objectlist);
				
				return objectlist;
			}else {
				// if the file doesn't exist, create an empty ArrayList to start the program
				List<Account> objectlist = new ArrayList<Account>();
				return objectlist;
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

