package exception;
//所有跟dao层有关的异常，秒杀业务相关的异常
public class SeckillException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SeckillException(String message, Throwable cause) {
		super(message, cause);

	}

	public SeckillException(String message) {
		super(message);

	}

}
