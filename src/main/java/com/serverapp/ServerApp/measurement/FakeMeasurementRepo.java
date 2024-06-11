package com.serverapp.ServerApp.measurement;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FakeMeasurementRepo extends JpaRepository<FakeMeasurement, Long> {
}
