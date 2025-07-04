package pub2504.network;

public class Weather {

	Response response;
	
	public Weather() {
	}

	public Weather(Response response) {
		this.response = response;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "Weather [response=" + response + "]";
	}
	
	
}
