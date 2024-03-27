package fun.huala.v3bms.controller;


import fun.huala.v3bms.model.db.StaffEntity;
import fun.huala.v3bms.model.dto.ResponseDTO;
import fun.huala.v3bms.model.vo.IdsForm;
import fun.huala.v3bms.service.IStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/sys/staff")
public class StaffController {

    private final IStaffService staffService;

    @Autowired
    public StaffController(IStaffService staffService) {
        this.staffService = staffService;
    }


    @GetMapping("/list")
    public ResponseDTO handleStaffList() {
        List<StaffEntity> staffList = staffService.list();
        return new ResponseDTO().setCode(200).setData(staffList);
    }

    @PostMapping("")
    public ResponseDTO handleSaveStaff(@RequestBody StaffEntity staffEntity) {
        staffService.save(staffEntity);
        return new ResponseDTO().setCode(200).setMessage("保存成功");
    }

    @PutMapping("")
    public ResponseDTO handleUpdateStaff(@RequestBody StaffEntity staffEntity) {
        staffService.updateById(staffEntity);
        return new ResponseDTO().setCode(200).setMessage("更新成功成功");
    }


    @DeleteMapping("")
    public ResponseDTO handleUpdateStaff(@RequestBody IdsForm idsForm) {
        staffService.removeByIds(Arrays.asList(idsForm.getIds()));
        return new ResponseDTO().setCode(200).setMessage("删除成功");
    }

}
