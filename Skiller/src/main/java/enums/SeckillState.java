package enums;

public enum SeckillState {
	SUCCESS(1, "成功秒杀"), END(0, "秒杀结束"), REPEAT_KILL(-1, "重复秒杀"), INNER_ERROR(
			-2, "系统异常"), DATE_REWRITE(-3, "数据");

	private int state;
	private String info;

	private SeckillState(int state, String info) {
		this.state = state;
		this.info = info;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public static SeckillState stateinfo(int index) {
		for (SeckillState stateinfo : values()) {
			if (stateinfo.getState() == index) {
				return stateinfo;
			}
		}
		return null;
	}

}
