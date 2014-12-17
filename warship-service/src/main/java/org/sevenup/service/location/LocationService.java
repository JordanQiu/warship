package org.sevenup.service.location;

import java.util.List;

import org.sevenup.domain.location.Location;
import org.springframework.data.geo.Box;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;

public interface LocationService {
	   List<Location> findByPositionWithin(Circle circle);
	   
	   List<Location> findByPositionWithin(Box box);
	   
	   List<Location> findByPositionNear(Point point, Distance distance);
}
