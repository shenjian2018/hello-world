package exception;
//秒杀关闭时，用户还要进行秒杀，就会抛出這个异常
public class SeckillCloseException extends SeckillException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SeckillCloseException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public SeckillCloseException(String message) {
		super(message);
		
	}
	

	
	
	
}
