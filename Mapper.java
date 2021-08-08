package inventorydetailmodel;
	import java.io.*;
	import org.codehaus.jackson.JsonParseException;
	import org.codehaus.jackson.map.JsonMappingException;
	import org.codehaus.jackson.map.ObjectMapper;

	public class Mapper {
		
		private static ObjectMapper mapper;
		static {
			mapper = new ObjectMapper();
		}

		// For Reading the json File, Parse and Return the mapped Object
		public static Object readMapper(String path, Object object)
				throws JsonParseException, JsonMappingException, IOException {
			
			return mapper.readValue(new File(path), object.getClass());

		}

		// For Writing the json File
		public static String writeMapper(String path, Object object)
				throws JsonParseException, JsonMappingException, IOException {
			
			mapper.writeValue(new File(path), object);
			return "Successfully writing into the File";

		}
	}

