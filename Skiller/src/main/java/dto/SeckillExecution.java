package dto;

import com.imooc.entity.SuccessKilled;

import enums.SeckillState;

public class SeckillExecution {

	private long seckillId;
	// 秒杀执行的状态
	private int state;
	// 秒杀执行的明文标识
	private String stateInfo;
	// 秒杀成功，返回的秒杀成功对象
	private SuccessKilled successKilled;

	public SeckillExecution(long seckillId, SeckillState seckillState,
			SuccessKilled successKilled) {

		this.seckillId = seckillId;
		this.state = seckillState.getState();
		this.stateInfo = seckillState.getInfo();
		this.successKilled = successKilled;
	}

	public SeckillExecution(long seckillId, SeckillState state) {

		this.seckillId = seckillId;
		this.state = state.getState();
		this.stateInfo = state.getInfo();
	}

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public SuccessKilled getSuccessKilled() {
		return successKilled;
	}

	public void setSuccessKilled(SuccessKilled successKilled) {
		this.successKilled = successKilled;
	}

}
