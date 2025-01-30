package com.hossain.ebrahim.tests;

import com.hossain.ebrahim.api.endpoinds.AuthEndpoint;
import com.hossain.ebrahim.api.endpoinds.BookingEndpoint;
import com.hossain.ebrahim.api.utils.RequestBodyBuilder;
import com.hossain.ebrahim.model.Booking;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class BookingTests {
    private static BookingEndpoint bookingEndpoint;
    private static String token;
    private int bookingId;
    private Booking booking;

    @BeforeClass
    public void setup() {
        // Setup the booking endpoint
        bookingEndpoint = new BookingEndpoint();

        // Create a token for authenticated requests
        String authBody = RequestBodyBuilder.createAuthBody("admin", "password123");
        Response authResponse = new AuthEndpoint().createToken(authBody);
        token = authResponse.jsonPath().getString("token");

        // Read booking from JSON file
        booking = RequestBodyBuilder.readBookingFromJson();

        // Ensure booking data is not null
        if (booking == null) {
            throw new RuntimeException("Failed to read booking data from JSON file.");
        }
    }

    @Test(priority = 1)
    public void testCreateBooking() {
        // Create a booking by sending a POST request
        String requestBody = RequestBodyBuilder.createBookingBody(booking);
        Response response = bookingEndpoint.createBooking(requestBody);

        // Extract the booking ID from the response for use in other tests
        bookingId = response.jsonPath().getInt("bookingid");
        System.out.println("Booking ID: " + bookingId);

        // Validate the response
        response.then()
                .statusCode(200)  // Check if the status code is 200 OK
                .body("bookingid", notNullValue())  // Assert booking ID is returned
                .body("booking.firstname", equalTo(booking.getFirstname()))
                .body("booking.lastname", equalTo(booking.getLastname()))
                .body("booking.totalprice", equalTo(booking.getTotalprice()))
                .body("booking.depositpaid", equalTo(booking.isDepositpaid()))
                .body("booking.bookingdates.checkin", equalTo(booking.getBookingdates().getCheckin()))
                .body("booking.bookingdates.checkout", equalTo(booking.getBookingdates().getCheckout()))
                .body("booking.additionalneeds", equalTo(booking.getAdditionalneeds()));
    }

    @Test(priority = 2, dependsOnMethods = "testCreateBooking")
    public void testGetBookingById() {
        // Ensure bookingId is valid
        if (bookingId <= 0) {
            throw new IllegalArgumentException("Invalid booking ID: " + bookingId);
        }

        // Log before fetching the booking
        System.out.println("Fetching booking with ID: " + bookingId);

        // Fetch a booking by its ID
        Response response = bookingEndpoint.getBookingById(bookingId);

        // Log the response for debugging
        System.out.println("Get Booking Response: " + response.asString());

        // Validate the response
        response.then()
                .statusCode(200)  // Check if the status code is 200 OK
                .body("firstname", equalTo(booking.getFirstname()))
                .body("lastname", equalTo(booking.getLastname()))
                .body("totalprice", equalTo(booking.getTotalprice()))
                .body("depositpaid", equalTo(booking.isDepositpaid()))
                .body("bookingdates.checkin", equalTo(booking.getBookingdates().getCheckin()))
                .body("bookingdates.checkout", equalTo(booking.getBookingdates().getCheckout()))
                .body("additionalneeds", equalTo(booking.getAdditionalneeds()));
    }

}