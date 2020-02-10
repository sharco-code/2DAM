import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class ClienteFTP1 {

	private static final String URL = "ftp.rediris.es";
	
	public static void main(String[] args) {

		FTPClient client = new FTPClient();
		log("Conectando a '"+URL+"' ");
		try {
			client.connect(URL);
			
			log("String de Respuesta:\n"+client.getReplyString());
			log("Respuesta: "+client.getReplyCode());
			
			if(!FTPReply.isPositiveCompletion(client.getReplyCode())) {
				client.disconnect();
				error("Conexion rechazada");
				System.exit(0);
			}
			client.disconnect();
			log("Conexion finalizada");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	private static void log(String msg) {
		System.out.println("[LOG] "+msg);
	}

	private static void error(String msg) {
		System.out.println("[ERROR] "+msg);
	}
}
