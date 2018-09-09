package exception;

/**
 * 
 * 重复秒杀，是一个运行期的异常，不需要我们手动try catch
 * 
 * @author shenjian
 * 
 */
public class RepeatKillException extends SeckillException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RepeatKillException(String message, Throwable cause) {
		super(message, cause);

	}

	public RepeatKillException(String message) {
		super(message);

	}

}
