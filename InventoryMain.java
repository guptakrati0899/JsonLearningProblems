package inventorydetailmodel;
import java.io.*;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class InventoryMain {

	
		
		public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

			String path = "C:\\Users\\Asus\\eclipse-workspace\\JsonLearningProblems\\JsonOutput";
			String path2 = "C:\\Users\\Asus\\eclipse-workspace\\JsonLearningProblems\\JsonOutput";

			ObjectMapper mapper = new ObjectMapper();

			// Code for Writing into Files
			InventoryModel model = mapper.readValue(new File(path), InventoryModel.class);

			int total = 0;
			System.out.println("Rice : " + model.getRice().get(0).getName());
			System.out.println("Price : " + model.getRice().get(0).getPrice_per_kg());
			total += model.getRice().get(0).getPrice_per_kg();
			System.out.println("wheats : " + model.getWheats().get(0).getName());
			System.out.println("Price : " + model.getWheats().get(0).getPrice_per_kg());
			total += model.getWheats().get(0).getPrice_per_kg();
			System.out.println("pulses : " + model.getPulses().get(0).getName());
			System.out.println("Price : " + model.getPulses().get(0).getPrice_per_kg());
			total += model.getPulses().get(0).getPrice_per_kg();
			System.out.println("\nTotal : " + total);

			// Code for Writing All Details into New File
			model.setTotal(total);
			mapper.writeValue(new File(path2), model);
			System.out.println("\nWrite into the File is Completed!!");
		}
	}

