
public class DemandModel {
	int uuid;
	public int getUuid() {
		return uuid;
	}
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
	public double getDemand_for_resource() {
		return demand_for_resource;
	}
	public void setDemand_for_resource(double demand_for_resource) {
		this.demand_for_resource = demand_for_resource;
	}
	double demand_for_resource;
	public DemandModel(int uuid, double demand_for_resource) {
		super();
		this.uuid = uuid;
		this.demand_for_resource = demand_for_resource;
	}
	

}
