# Uber-Api-Design
Designing MVP for a cab booking application similar to Uber.

* Requirements.
* Low Level Design.
* High Level Design.
* API Design.
* Building Microservices.
* Deploying Services.

Technologies Used - Spring Boot, Hibernate, JPA, PostgresSQL, Redis.

# Requirements:

  ### Passengers: 

* Passengers register by entering the phone number and confirming the OTP
* Passenger can request a cab booking by entering source and destination.
* Before booking the cab, passenger will see the ETA for the booking, the expected ride duration and the expected cost.
* After booking the ride also passenger should be able to see their ETA, expected ride duration and expected cost.
* Booking can be scheduled for now, or can be scheduled for a later time - max 3 days.
* Passenger can cancel an upcoming booking, if booking is scheduled for later time.
* A ride in progress cannot be cancelled - it can only be ended by the driver and passenger must pay some amount after ending the ride from driver side based on payment method.
* A Passenger can rate their experience of the current booking during the ride or after the ride has ended.
* Passengers can see their past, current and upcoming bookings.
* Passenger can update profile, update payment methods and other profile specific requirements.
* Ride sharing can be part of extensible feature.

  ### Booking:

* There are multiple types of bookings available - XL, Pool, Prime, Go, Rental
* When making a booking, the passenger must choose the type of booking.
* Once a booking is requested, the nearby drivers are alerted about the booking 
* The first driver to accept the booking is allotted to it.
* Drivers are chosen based on ETA to the location.
* While the trip is active, the passenger can add/remove/rearrange the stops, and the driver will be notified in real time.
* To start a ride, the passenger must share an OTP with the driver.
* The driver can end the ride at any time.

  ### Driver:
* After registering the driver must fill their profile and car details.
* The driver is allowed to accept rides only after their profile is approved by the admin.
* Only one car can be registered with one account. If a driver has multiple cars, they must use different accounts.
* Driver can see what booking they can accept, based on the real time notifications they are getting.
* Driver can see the expected earning from a booking.
* Driver can choose to accept a booking or to ignore it.
* Driver should not drive more than 14-hrs per day, so we should restrict the driver to further accept any bookings.

  ### System:
* The system must track each cab in real time.
* The system must should have a basic observability for different processes.
* Passenger can request a new booking only if they don’t have any pending payment.
* Admin panel to see statistics or any other admin related stuffs.


  ### Schema Design:

![](./uber_uml.png)



