package com.posun.domain.model;

import com.posun.domain.valueObject.Booking.TypeServiceVO;

import java.time.LocalDate;

public class Booking {
    private Long bookingId;
    private Long tenantId;
    private UserClient userClient;
    private ServiceType typeService;
    private Employee electedEmployee;
    private LocalDate startBooking;
    private LocalDate endBooking;
    private BookingState bookingState;
    

    public Booking(){}

    public Booking(Long bookingId,Long tenantId,UserClient userClient, ServiceType typeService,
                   Employee electedEmployee, LocalDate startBooking, LocalDate endBooking, BookingState bookingState) {
        this.bookingId = bookingId;
        this.tenantId = tenantId;
        this.userClient = userClient;
        this.typeService = typeService;
        this.electedEmployee = electedEmployee;
        this.startBooking = startBooking;
        this.endBooking = endBooking;
        this.bookingState = bookingState;
    }

    private Booking (BookingBuilder builder){
        this.bookingId = builder.bookingId;
        this.tenantId = builder.tenantId;
        this.userClient = builder.userClient;
        this.typeService = builder.typeService;
        this.electedEmployee = builder.electedEmployee;
        this.startBooking = builder.startBooking;
        this.endBooking = builder.endBooking;
        this.bookingState = builder.bookingState;
    }

    public BookingBuilder toBuilder(){
        return new BookingBuilder()
                .withBookingId(this.bookingId)
                .withUserClient(this.userClient)
                .withTypeService(this.typeService)
                .withElectedEmployee(this.electedEmployee)
                .withTenantId(this.tenantId)
                .withStartBooking(this.startBooking)
                .withEndBooking(this.endBooking)
                .withBookingState(this.bookingState);
    }

    public static BookingBuilder builder(){
        return new BookingBuilder();
    }

    public static class  BookingBuilder{
        private Long bookingId;
        private Long tenantId;
        private UserClient userClient;
        private ServiceType typeService;
        private Employee electedEmployee;
        private LocalDate startBooking;
        private LocalDate endBooking;
        private BookingState bookingState;


        public BookingBuilder withBookingId(Long bookingId){
            this.bookingId = bookingId;
            return this;
        }
        public BookingBuilder withTenantId(Long tenantId){
            this.tenantId = tenantId;
            return this;
        }
        public BookingBuilder withUserClient(UserClient userClient){
            this.userClient = userClient;
            return this;
        }
        public BookingBuilder withTypeService(ServiceType typeService){
            this.typeService = typeService;
            return this;
        }
        public BookingBuilder withElectedEmployee(Employee electedEmployee){
            this.electedEmployee = electedEmployee;
            return this;
        }
        public BookingBuilder withStartBooking(LocalDate startBooking){
            this.startBooking = startBooking;
            return this;
        }
        public BookingBuilder withEndBooking(LocalDate endBooking){
            this.endBooking = endBooking;
            return this;
        }
        public BookingBuilder withBookingState(BookingState bookingState){
            this.bookingState = bookingState;
            return this;
        }
        public Booking build(){
            return new Booking(this);
        }
    }

    public Long getBookingId() {
        return bookingId;
    }

    public UserClient getUserClient() {
        return userClient;
    }

    public ServiceType getTypeService() {
        return typeService;
    }

    public Employee getElectedEmployee() {
        return electedEmployee;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public LocalDate getStartBooking() {
        return startBooking;
    }

    public LocalDate getEndBooking() {
        return endBooking;
    }

    public BookingState getBookingState() {
        return bookingState;
    }
}
