package oskarpolak.lombok;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public @Data class OskarData {
	private String name;
	private String location;
	private String home;
	private OskarData homePlayer;

	private String testGetName(String name) {
		return name + " | to naprawdę tutaj było";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OskarData other = (OskarData) obj;
		if (home == null) {
			if (other.home != null)
				return false;
		} else if (!home.equals(other.home))
			return false;
		if (homePlayer == null) {
			if (other.homePlayer != null)
				return false;
		} else if (!homePlayer.equals(other.homePlayer))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((home == null) ? 0 : home.hashCode());
		result = prime * result + ((homePlayer == null) ? 0 : homePlayer.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	 

	
	
	


	
}
