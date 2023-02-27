package conversores;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class getMoedas {

	public static void main(String[] args) throws IOException, Throwable {
		// TODO Auto-generated method stub
		HttpClient client = HttpClient.newHttpClient(); // envia a requisição
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://economia.awesomeapi.com.br/last/USD-BRL,EUR-BRL,BTC-BRL"))
				.GET()
				//.header(null, null) // authorization - value authorization
				.header("Content-Type", "application/json")
				.build();
		
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); //receber a resposta como String ou como Path(arquivo)
		
		System.out.println(response.body());
		System.out.println(response.statusCode());
		
		//
		
		Gson gson = new GsonBuilder().create();
		
		String json = response.body();
		
		ResponseWrapper varResponse = gson.fromJson(json, ResponseWrapper.class); // json(var) ou o método 
		
		System.out.println(varResponse.BTCBRL.name);
		System.out.println(varResponse.BTCBRL.bid);
		System.out.println(varResponse.BTCBRL.ask);
		System.out.println(varResponse.BTCBRL.create_date);
	}
	
	public static ResponseWrapper getValores() throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient(); // envia a requisição
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://economia.awesomeapi.com.br/last/USD-BRL,EUR-BRL,BTC-BRL"))
				.GET()
				//.header(null, null) // authorization - value authorization
				.header("Content-Type", "application/json")
				.build();
		
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); //receber a resposta como String ou como Path(arquivo)
		
				
		//
		
		Gson gson = new GsonBuilder().create();
		
		String json = response.body();
		
		ResponseWrapper varResponse = gson.fromJson(json, ResponseWrapper.class); // json(var) ou o método 
		return varResponse;
	}
	
	
	
	public class ResponseWrapper{
		// @JsonProperty("USDBRL") // ignorar - usava jakson
		public cls_USDBRL USDBRL;
	    // @JsonProperty("EURBRL") 
		public cls_EURBRL EURBRL;
	    // @JsonProperty("BTCBRL") 
		public cls_BTCBRL BTCBRL;
	}
		public class cls_USDBRL {
			public String code;	//USD
			public String codein;	//BRL
			public String name;	//Dólar Americano/Real Brasileiro
			public String high;	//5.2097
			public String low;	//5.135
			public String varBid;	//0.0692
			public String pctChange;	//1.35
			public Double bid;	//5.206
			public Double ask;	//5.207
			public String timestamp;	//1677273079
			public String create_date;	//2023-02-24 18:11:19
		}
		public class cls_EURBRL {
			public String code;	//EUR
			public String codein;	//BRL
			public String name;	//Euro/Real Brasileiro
			public String high;	//5.4943
			public String low;	//5.4328
			public String varBid;	//0.0483
			public String pctChange;	//0.89
			public Double bid;	//5.4897
			public Double ask;	//5.4929
			public String timestamp;	//1677273079
			public String create_date;	//2023-02-24 18:11:19
		}
		public class cls_BTCBRL {
			public String code;	//BTC
			public String codein;	//BRL
			public String name;	//Bitcoin/Real Brasileiro
			public String high;	//124484
			public String low;	//120000
			public String varBid;	//-1949
			public String pctChange;	//-1.58
			public Double bid;	//121403
			public Double ask;	//121441
			public String timestamp;	//1677273083
			public String create_date;	//2023-02-24 18:11:23
		}

}
