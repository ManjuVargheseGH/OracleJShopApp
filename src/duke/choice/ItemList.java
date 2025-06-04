package duke.choice;

import io.helidon.common.http.Http;
import io.helidon.webserver.Handler;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;

/**
 * 
 * @author MANJU
 *
 */
public class ItemList implements Handler{
	
	private Clothing[] items;
	 

	/**
	 * @param items
	 */
	public ItemList(Clothing[] items) {
		this.items = items;
	}


	@Override
	public void accept(ServerRequest req, ServerResponse res) {
		// TODO Auto-generated method stub
		res.status(Http.Status.OK_200);
		res.headers().put("Content-Type", "text/plain; charset=UTF-8");
		StringBuilder result=new StringBuilder();
		for(Clothing eachCloth:items) {
			result.append(eachCloth+"\n");
		}
		res.send(result);
	}

}
