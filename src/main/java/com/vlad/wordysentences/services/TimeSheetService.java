package com.vlad.wordysentences.services;

import com.vlad.wordysentences.exceptions.NotFoundException;
import com.vlad.wordysentences.models.*;
import com.vlad.wordysentences.repositories.CustomerRepository;
import com.vlad.wordysentences.repositories.StaffRepository;
import com.vlad.wordysentences.repositories.TimeLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;


@Service
public class TimeSheetService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    StaffRepository staffRepository;
    @Autowired
    TimeLogRepository timeLogRepository;

    public Customer createCustomer(CreateCustomerRequest createCustomerRequest){
        Customer customer = new Customer(createCustomerRequest);
        try {
            customer = customerRepository.save(customer);
        }catch (DataAccessException e){
            e.printStackTrace();
        }
        return customer;
    }

    public Customer createCustomer(int id){
        Optional<Customer> optionalCustomer= customerRepository.findById(id);
        if(optionalCustomer.isPresent()){
            return optionalCustomer.get();
        }else {
            return null;
        }
    }

    public Staff createStaff(CreateStaffRequest createStaffRequest){
        Staff staff = new Staff(createStaffRequest);
        Optional<Customer> customerExists = customerRepository.findById(createStaffRequest.getEmployerId());
        if(customerExists.isPresent()){
            try {
                Customer customer = customerExists.get();
                staff = staffRepository.save(staff);
                customer.getStaffList().add(staff);
                customerRepository.save(customer);
            }catch (DataAccessException e){
                e.printStackTrace();
            }
        }else {
            throw new NotFoundException("Employer with id:"+createStaffRequest.getEmployerId()+" does not exist");
        }
        return staff;
    }

    public TimeLog logTime(CreateLogRequest createLogRequest){
        TimeLog timeLog = new TimeLog();
        Optional<Staff> optionalStaff = staffRepository.findById(createLogRequest.getStaffId());
        if(optionalStaff.isPresent()){
            Optional<TimeLog> alreadyLoggedToday = timeLogRepository.findTimeLogsByStaffIdAndAndCurrentDateEquals(createLogRequest.getStaffId(),getCurrntDateOnly());
            if(alreadyLoggedToday.isPresent()){
                timeLog = alreadyLoggedToday.get();
                timeLog.setClockOut(new Date());
            }else {
                timeLog.setClockIn(new Date());
                timeLog.setClockOut(new Date());
                timeLog.setCurrentDate(getCurrntDateOnly());
                timeLog.setStaffId(createLogRequest.getStaffId());
            }
            timeLogRepository.save(timeLog);
        }else {
            throw new NotFoundException("Staff with id:"+createLogRequest.getStaffId()+" does not exist");
        }
        return timeLog;
    }

    private String getCurrntDateOnly(){
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter s= DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return localDate.format(s);
    }
}
