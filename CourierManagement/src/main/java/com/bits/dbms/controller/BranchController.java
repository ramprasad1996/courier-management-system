package com.bits.dbms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bits.dbms.model.Branch;
import com.bits.dbms.repository.BranchRepository;

@RestController
@CrossOrigin
@RequestMapping(path="/branch")
public class BranchController {
	
	@Autowired
	private BranchRepository branchRepo;
	
	@PostMapping("/addBranch")
	public @ResponseBody String addNewUser(@RequestBody Branch branch) {
		branchRepo.save(branch);
		return "Branch Saved";
	}

}
