package com.bluerbn.flight.svc;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bluerbn.flight.repo.BaggageRepository;

/**
 * @author avim
 * @since 22/10/2018
 * @version $Id$
 */
@Service
public class BaggageServiceImpl implements BaggageService {

	@Resource
	private BaggageRepository baggageRepository;

	@Override
	public boolean checkIn(String baggageId, long destinationId) {
		return baggageRepository.checkIn(baggageId, destinationId);
	}

}
