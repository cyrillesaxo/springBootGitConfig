
CREATE KEYSPACE IF NOT EXISTS BaggageEvent WITH replication = {'class':'SimpleStrategy', 'replication_factor':3};

CREATE TABLE IF NOT EXISTS BaggageEvent.Passenger(
	BagEventId text,
	PassengerNameRecordLocator text,
	GenderCode text,
	MiddleName text,
	TitleName text,
	SurName text,
	GivenName text,
	BirthDate text,
	BagEventDate timestamp,
	PRIMARY KEY ( BagEventId, PassengerNameRecordLocator, BagEventDate)
) WITH CLUSTERING ORDER BY (PassengerNameRecordLocator ASC, BagEventDate DESC);
CREATE INDEX IF NOT EXISTS PassengerNameRecordLocator_idx ON BaggageEvent.Passenger(PassengerNameRecordLocator);
CREATE INDEX IF NOT EXISTS BagEventDate_idx ON BaggageEvent.Passenger(BagEventDate);	


CREATE TABLE IF NOT EXISTS BaggageEvent.BagSegment(
	BagEvenId text,
	SegmentFlightID text,
	SegmentScheduledDepartureDate text,
	SegmentAilineOperatorCode text,
	SegmentServiceOfferCabinClass text,
	GroundTransportCarriageMediumCode text,
	GroundTransportGroundTransportID text,	
	AircraftRegistrationID text,
	AircraftRegistrationPrefixCode text,
	SegmentSecurityControlContainerSealed text,
	SegmentArrivalFacilityAirportCode text,	
	SegmentDepartureFacilityTerminalID text,
	SegmentDepartureFacilityTerminalCheckInIdentfier text,
	SegmentDepartureFacilityAirportCode text,	
	BagSegmentDate timestamp,	
	PRIMARY KEY (BagEvenId, SegmentFlightID, BagSegmentDate)
) WITH CLUSTERING ORDER BY (SegmentFlightID ASC, BagSegmentDate DESC);
CREATE INDEX IF NOT EXISTS SegmentFlightID_idx ON BaggageEvent.BagSegment(SegmentFlightID);
CREATE INDEX IF NOT EXISTS BagSegmentDate_idx ON BaggageEvent.BagSegment(BagSegmentDate);	

CREATE TABLE IF NOT EXISTS BaggageEvent.BagPosition(
	BagEvenId text,
	AreaID text,
	BagPositionDate timestamp,	
	PRIMARY KEY (BagEvenId, AreaID, BagPositionDate)
) WITH CLUSTERING ORDER BY (AreaID ASC,  BagPositionDate DESC);
CREATE INDEX IF NOT EXISTS AreaID_idx ON BaggageEvent.BagPosition(AreaID);
CREATE INDEX IF NOT EXISTS BagPositionDate_idx ON BaggageEvent.BagPosition(BagPositionDate);	



CREATE TABLE IF NOT EXISTS BaggageEvent.BagTag(
	BagEvenId text,
	TagID text,
	BagTagDate timestamp,	
	PRIMARY KEY (BagEvenId, TagID , BagTagDate)
) WITH CLUSTERING ORDER BY (TagID  ASC, BagTagDate DESC );
CREATE INDEX IF NOT EXISTS TagID_idx ON BaggageEvent.BagTag(TagID);
CREATE INDEX IF NOT EXISTS BagTagDate_idx ON BaggageEvent.BagTag(BagTagDate);	


CREATE TABLE IF NOT EXISTS BaggageEvent.BaggageActivity(
	BagEvenId text,
	ActivitySequenceOrdinal text,
	ActivityActualDateTime text,
	ActivityEarliestDateTime text,
	ActivitySecondaryCode text,
	ActivityDescriptionText text,
	BaggageActivityCode text,
	ActivityLatestDateTime text,
	BaggageActivityDate timestamp,	
	PRIMARY KEY (BagEvenId, ActivitySequenceOrdinal, BaggageActivityDate)
) WITH CLUSTERING ORDER BY ( ActivitySequenceOrdinal ASC,  BaggageActivityDate DESC );
CREATE INDEX IF NOT EXISTS ActivitySequenceOrdinal_idx ON BaggageEvent.BaggageActivity(ActivitySequenceOrdinal);
CREATE INDEX IF NOT EXISTS BaggageActivityDate_idx ON BaggageEvent.BaggageActivity(BaggageActivityDate);	