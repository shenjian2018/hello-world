package dto;

/**
 * 
 * @author shenjian 暴露秒杀地址DTO
 */
public class Exposer {
	@Override
	public String toString() {
		return "Exposer [exposer=" + exposer + ", seckillId=" + seckillId
				+ ", md5=" + md5 + ", now=" + now + ", start=" + start
				+ ", end=" + end + "]";
	}

	// 是否开启秒杀
	private boolean exposer;

	private long seckillId;
	// 加密措施
	private String md5;
	// 当前系统时间
	private long now;
	// 秒杀开始时间
	private long start;
	// 秒杀结束时间
	private long end;

	public Exposer(boolean exposer, long seckillId) {
		super();
		this.exposer = exposer;
		this.seckillId = seckillId;
	}

	public Exposer(boolean exposer, long seckillId, long now, long start,
			long end) {
		super();
		this.exposer = exposer;
		this.seckillId = seckillId;
		this.now = now;
		this.start = start;
		this.end = end;
	}

	public Exposer(boolean exposer, long seckillId, String md5) {
		super();
		this.exposer = exposer;
		this.seckillId = seckillId;
		this.md5 = md5;
	}

	public boolean isExposer() {
		return exposer;
	}

	public void setExposer(boolean exposer) {
		this.exposer = exposer;
	}

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public long getNow() {
		return now;
	}

	public void setNow(long now) {
		this.now = now;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

}
