package com.garmentsmanagement.GM;

import com.garmentsmanagement.GM.entity.employeeEntity.Employees;
import com.garmentsmanagement.GM.entity.employeeEntity.SalaryGrade;
import com.garmentsmanagement.GM.entity.productionLine.Inventory.ProductionR;
import com.garmentsmanagement.GM.entity.productionLine.productionDepts.ProductionRequisition;
import com.garmentsmanagement.GM.repository.clientRepository.ICOrderRepository;
import com.garmentsmanagement.GM.repository.productionLine.InventoryPlRepo;
import com.garmentsmanagement.GM.repository.productionLine.InventoryRepo.ProductionRRepo;
import com.garmentsmanagement.GM.service.clientService.ClientOrderService;
import com.garmentsmanagement.GM.service.employeeService.DeptService;
import com.garmentsmanagement.GM.service.employeeService.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GarmentsManagementApplicationTests {

	@Autowired
    EmployeeService employeeService;

	@Autowired
	ProductionRRepo productionRRepo;

	@Test
	void contextLoads() {
		List<ProductionR> lists = productionRRepo.getactiveOrder(1);
//		List<ProductionR> lists = productionRRepo.findAll().stream().filter(lis);

			System.out.println(lists);

	}
	@Autowired
	ICOrderRepository orderCount;

	@Test
	void countOrder(){
		String orCount = orderCount.findClientAllOrder(1);

		System.out.println(orCount);
	}

	@Test
	void x(){

		System.out.println(employeeService.findStartData("Dept 2-2023-Grade-14-1003"));

//		System.out.println(hrService.findEmpByEmid("Dept 2-2023-Grade-14-1003"));
//		StartAttend at = new StartAttend();

//		hrService.saveAttend(new StartAttend("Dept 2-2023-Grade-14-1003"));
	}

	@Autowired
	DeptService deptService;

	@Test
	void generateText(){
		long id = 1;
			List<SalaryGrade> list = deptService.findSgById(id);
//		System.out.println(Arrays.toString(list));

	}

	@Autowired
	InventoryPlRepo inventoryPlRepo;

	@Test
	void xx(){
//		List<InventoryPL> l = inventoryPlRepo.findInvByOrderId(1);
//		System.out.println(l);
	}


	@Autowired
	ClientOrderService coService;

	@Test
	void xxx(){
		System.out.println(employeeService.findEmpById(2));

	}

}
