package com.aoct.emr.provider.externalResponseModel;

import java.util.List;

import lombok.Data;

@Data
public class ExternalServiceResponseModel {
    private int result_count;
    private List<Result> results;

    // ...getters and setters for the fields...
    @Data
    public static class Result {
        private String created_epoch;
        private String enumeration_type;
        private String last_updated_epoch;
        private String number;
        private List<Address> addresses;
        private List<Object> practiceLocations; // You may define a proper class for practiceLocations if needed
        private Basic basic;
        private List<Taxonomy> taxonomies;
        private List<Object> identifiers; // You may define a proper class for identifiers if needed
        private List<Object> endpoints; // You may define a proper class for endpoints if needed
        private List<Object> other_names; // You may define a proper class for other_names if needed

        // ...getters and setters for the fields...
        @Data
        public static class Address {
            private String country_code;
            private String country_name;
            private String address_purpose;
            private String address_type;
            private String address_1;
            private String address_2;
            private String city;
            private String state;
            private String postal_code;
            private String telephone_number;
            private String fax_number; // This field is optional

            // ...getters and setters for the fields...
        }
        @Data
        public static class Basic {
            private String first_name;
            private String last_name;
            private String middle_name;
            private String credential;
            private String sole_proprietor;
            private String gender;
            private String enumeration_date;
            private String last_updated;
            private String status;
            private String name_prefix;

            // ...getters and setters for the fields...
        }
        @Data
        public static class Taxonomy {
            private String code;
            private String taxonomy_group;
            private String desc;
            private String state;
            private String license;
            private boolean primary;

            // ...getters and setters for the fields...
        }
    }
}