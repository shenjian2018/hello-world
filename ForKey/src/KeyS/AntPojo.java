package KeyS;

@Table("User")
public class AntPojo {
	@Column(length = 20, name = "id", type = "varchar")
	private String id;
	@Column(length = 20, name = "name", type = "")
	private String name;
	@Column(length = 20, name = "desc", type = "varchar")
	private String desc;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "AntPojo [id=" + id + ", name=" + name + ", desc=" + desc + "]";
	}

}
