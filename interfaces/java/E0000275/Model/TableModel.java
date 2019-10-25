package E0000275.Model;

import javax.swing.table.DefaultTableModel;

import java.io.FileReader;
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@SuppressWarnings("serial")
public class TableModel extends DefaultTableModel {

	private ArrayList<Coche> TodasLasEmpresas = new ArrayList();

	public static final Object[] TABLE_HEADER = { "ID", "Marca", "Modelo", "Color", "Combustible", "Precio" };
	public static Object[][] DATA;

	public TableModel() throws ParseException, IOException {
		this.Crear();
		this.Cargar();
	}

	public void Crear() throws FileNotFoundException {
		JSONObject jo = new JSONObject();
		JSONArray ja = new JSONArray();
		Map map;

		map = new LinkedHashMap(6);
		map.put("ID", 1);
		map.put("Marca", "Citroen");
		map.put("Modelo", "C4");
		map.put("Color", "Blanco");
		map.put("Combustible", "Diesel");
		map.put("Precio", 15000);
		ja.add(map);

		map = new LinkedHashMap(6);
		map.put("ID", 2);
		map.put("Marca", "Ford");
		map.put("Modelo", "Focus");
		map.put("Color", "Rojo");
		map.put("Combustible", "Gasolina");
		map.put("Precio", 21000);
		ja.add(map);
		
		jo.put("Coches", ja);

		String fiele = System.getProperty("user.dir") + "\\data\\JSONExample.json";
		
		PrintWriter pw = new PrintWriter(fiele);
		pw.write(jo.toJSONString());
		pw.flush();
		pw.close();

	}

	public void Cargar() throws FileNotFoundException, ParseException, IOException {

		this.setDataVector(this.DATA, this.TABLE_HEADER);

		String file = System.getProperty("user.dir") + "\\data\\JSONExample.json";

		Object object = new JSONParser().parse(new FileReader(file));
		JSONObject jo = (JSONObject) object;

		JSONArray ja = (JSONArray) jo.get("Coches");
		JSONObject jsonObj = null;
		for (int i = 0; i < ja.size(); i++) {
			jsonObj = (JSONObject) ja.get(i);

			Integer ID = Integer.parseInt(jsonObj.get("ID").toString());
			String Marca = (String) jsonObj.get("Marca");
			String Modelo = (String) jsonObj.get("Modelo");
			String Color = (String) jsonObj.get("Color");
			String Combustible = (String) jsonObj.get("Combustible");
			Double Precio = Double.parseDouble(jsonObj.get("Precio").toString());

			Object[] obj2 = new Object[] { ID, Marca, Modelo, Color, Combustible, Precio };

			Coche e = new Coche(ID, Marca, Modelo, Color, Combustible, Precio);
			TodasLasEmpresas.add(e);

			this.addRow(obj2);
		}

	}
}
