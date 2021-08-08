package inventorydetailmodel;
import java.util.ArrayList;
import java.io.*;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

	public class InventoryManagement {
		
		public static void main(String[] args) 
				throws JsonParseException, JsonMappingException, IOException {
			
			System.out.print("Hello Manager!!");
			System.out.println(" Lets Add Inventory");
			System.out.println("How much inventory you want to add");
			String path = "C:\\Users\\Asus\\eclipse-workspace\\JsonLearningProblems\\JsonOutput";
			String oldFilePath = "C:\\Users\\Asus\\eclipse-workspace\\JsonLearningProblems\\src\\InventoryInput.json";
			int num = Scanner1.integerScanner();

			int choice;
			String name;
			int weight;
			int pricePerKg;
			int totalPriceOfWeight;
			int inventoryGrandTotal = 0;
			InventoryModel model = new InventoryModel();

			model = (InventoryModel) Mapper.readMapper(oldFilePath, model);

			ArrayList<Rice> riceList = new ArrayList<Rice>();
			ArrayList<Pulses> pulsesList = new ArrayList<Pulses>();
			ArrayList<Wheats> wheatsList = new ArrayList<Wheats>();
			
			model.getRice().get(0)
					.setTotalPriceOfWeight(model.getRice().get(0).getWeight() * model.getRice().get(0).getPrice_per_kg());
			model.getPulses().get(0).setTotalPriceOfWeight(
					model.getPulses().get(0).getWeight() * model.getPulses().get(0).getPrice_per_kg());
			model.getWheats().get(0).setTotalPriceOfWeight(
					model.getWheats().get(0).getWeight() * model.getWheats().get(0).getPrice_per_kg());
			int riceSize = model.getRice().size();
			int pulsesSize = model.getPulses().size();
			int wheatsSize = model.getWheats().size();
			for (int i = 0; i <= model.getRice().size() - 1; i++) {
				inventoryGrandTotal += model.getRice().get(riceSize - 1).getTotalPriceOfWeight();
				riceSize--;
			}
			for (int i = 0; i <= model.getPulses().size() - 1; i++) {
				inventoryGrandTotal += model.getPulses().get(pulsesSize - 1).getTotalPriceOfWeight();
				pulsesSize--;
			}
			for (int i = 0; i <= model.getPulses().size() - 1; i++) {
				inventoryGrandTotal += model.getWheats().get(wheatsSize - 1).getTotalPriceOfWeight();
				wheatsSize--;
			}
			
			riceList.addAll(model.getRice());
			pulsesList.addAll(model.getPulses());
			wheatsList.addAll(model.getWheats());

			for (int i = 0; i < num; i++) {
				System.out.println("For Adding, Press -> \n1. For Rice\n2. For Pulses\n3. For Wheats: ");
				choice = Scanner1.integerScanner();

				switch (choice) {
				case 1:
					Rice rice = new Rice();
					System.out.println("Enter Name of Brand: ");
					name = Scanner1.stringScanner();
					System.out.println("Enter Weight: ");
					weight = Scanner1.integerScanner();
					System.out.println("Enter Price per Kg: ");
					pricePerKg = Scanner1.integerScanner();
					totalPriceOfWeight = weight * pricePerKg;

					inventoryGrandTotal += totalPriceOfWeight;

					rice.setName(name);
					rice.setWeight(weight);
					rice.setPrice_per_kg(pricePerKg);
					rice.setTotalPriceOfWeight(totalPriceOfWeight);

					riceList.add(rice);
					break;
					
				case 2:
					Pulses pulses = new Pulses();
					System.out.println("Enter name of brand: ");
					name = Scanner1.stringScanner();
					System.out.println("Enter weight: ");
					weight = Scanner1.integerScanner();
					System.out.println("Enter price per kg: ");
					pricePerKg = Scanner1.integerScanner();
					totalPriceOfWeight = weight * pricePerKg;

					inventoryGrandTotal += totalPriceOfWeight;

					pulses.setName(name);
					pulses.setWeight(weight);
					pulses.setPrice_per_kg(pricePerKg);
					pulses.setTotalPriceOfWeight(totalPriceOfWeight);

					pulsesList.add(pulses);
					break;
					
				case 3:
					Wheats wheats = new Wheats();
					System.out.println("Enter name of brand: ");
					name = Scanner1.stringScanner();
					System.out.println("Enter weight: ");
					weight = Scanner1.integerScanner();
					System.out.println("Enter price per kg: ");
					pricePerKg = Scanner1.integerScanner();
					totalPriceOfWeight = weight * pricePerKg;

					inventoryGrandTotal += totalPriceOfWeight;

					wheats.setName(name);
					wheats.setWeight(weight);
					wheats.setPrice_per_kg(pricePerKg);
					wheats.setTotalPriceOfWeight(totalPriceOfWeight);

					wheatsList.add(wheats);
					break;
					
				default:
					System.out.println("Please Select a Valid Option!");
					continue;
				}

			}

			model.setTotal(inventoryGrandTotal);
			model.setRice(riceList);
			model.setPulses(pulsesList);
			model.setWheats(wheatsList);

			System.out.println(Mapper.writeMapper(path, model));
			System.out.println("Inventory is Added into New json File!!");

		}
	}


