package com.imooc.entity;

import java.util.Date;

public class Seckill {
	private long seckillId;
	private String name;
	private int number;
	private Date startTime;
	private Date endTime;
	private Date createTime;

    //多对一,因为一件商品在库存中有很多数量，对应的购买明细也有很多。
    private Seckill seckill;

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Seckill(long seckillId, String name, int number, Date startTime,
			Date endTime, Date createTime) {
		super();
		this.seckillId = seckillId;
		this.name = name;
		this.number = number;
		this.startTime = startTime;
		this.endTime = endTime;
		this.createTime = createTime;
	}

	public Seckill() {
		super();
	}

	@Override
	public String toString() {
		return "Seckill [seckillId=" + seckillId + ", name=" + name
				+ ", number=" + number + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", createTime=" + createTime + "]";
	}

}
