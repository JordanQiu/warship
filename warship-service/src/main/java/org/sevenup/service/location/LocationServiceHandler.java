package org.sevenup.service.location;

import java.util.List;

import org.sevenup.domain.location.Location;
import org.springframework.data.geo.Box;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceHandler implements LocationService{
	private static final Point DUS = new Point( 6.810036, 51.224088 );
	@Override
	public List<Location> findByPositionWithin(Circle circle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> findByPositionWithin(Box box) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> findByPositionNear(Point point, Distance distance) {
		// TODO Auto-generated method stub
		return null;
	}

}
