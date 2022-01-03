package com.spring.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.model.Customer;

import pagination.Pagable;

@Service
public class CustomerRestClientImpl implements CustomerRestClient {

	private RestTemplate restTemplate;

	private String crmRestUrl;

	private Logger LOG = Logger.getLogger(getClass().getName());

	@Autowired
	public CustomerRestClientImpl(RestTemplate theRestTemplate, @Value("${crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
		LOG.info("CustomerRestClientImpl >> Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public Pagable<Customer> getAll(String sort, int page) {
		LOG.info("CustomerRestClientImpl >> getAll(sort)");
		ResponseEntity<Pagable<Customer>> responseEntity = restTemplate.exchange(
				crmRestUrl + "?sort=" + sort + "&page=" + page,
				HttpMethod.GET,
				null, 
				new ParameterizedTypeReference<Pagable<Customer>>() {
				});
		return responseEntity.getBody();
	}
	
	@Override
	public int countTotalElements() {
		ResponseEntity<Integer> response = restTemplate.exchange(
				crmRestUrl + "/total-elements",
				HttpMethod.GET, 
				null, 
				new ParameterizedTypeReference<Integer>() {
				});
		return response.getBody();
	}
	
	@Override
	public List<Customer> search(String keyword) {
		LOG.info("CustomerRestClientImpl >> search(keyword)");
		ResponseEntity<List<Customer>> responseEntity = restTemplate.exchange(
				crmRestUrl + "/filter?search=" + keyword,
				HttpMethod.GET, 
				null, 
				new ParameterizedTypeReference<List<Customer>>() {
				});
		return responseEntity.getBody();
	}
	
	@Override
	public int countTotalElements(String keyword) {
		return 0;
	}

	@Override
	public Customer get(int id) {
		LOG.info("CustomerRestClientImpl >> get(id)");
		return restTemplate.getForObject(crmRestUrl + "/" + id, Customer.class);
	}

	@Override
	public void save(Customer customer) {
		LOG.info("CustomerRestClientImpl >> save(customer)");
		int customerId = customer.getId();
		if (customerId == 0) {
			restTemplate.postForEntity(crmRestUrl, customer, String.class);
		} else {
			restTemplate.put(crmRestUrl, customer);
		}
	}

	@Override
	public void delete(int id) {
		LOG.info("CustomerRestClientImpl >> delete(id)");
		restTemplate.delete(crmRestUrl + "/" + id);
	}
}
