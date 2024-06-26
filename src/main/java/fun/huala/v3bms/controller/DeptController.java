package fun.huala.v3bms.controller;


import fun.huala.v3bms.model.db.DeptEntity;
import fun.huala.v3bms.model.dto.ResponseDTO;
import fun.huala.v3bms.model.vo.Ids;
import fun.huala.v3bms.service.IDeptService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/sys/dept")
@AllArgsConstructor
public class DeptController {

    private final IDeptService deptService;



    /**
     * 获取部门列表
     */
    @GetMapping("/list")
    public ResponseDTO handleStaffList() {
        List<DeptEntity> deptList = deptService.list();
        return new ResponseDTO().setCode(200).setData(deptList);
    }


    /**
     * 添加部门
     */
    @PostMapping("")
    public ResponseDTO handleSaveStaff(@RequestBody DeptEntity deptEntity) {
        deptService.save(deptEntity);
        return new ResponseDTO().setCode(200).setMessage("保存成功");
    }

    /**
     * 更新部门信息
     */
    @PutMapping("")
    public ResponseDTO handleUpdateStaff(@RequestBody DeptEntity deptEntity) {
        deptService.updateById(deptEntity);
        return new ResponseDTO().setCode(200).setMessage("更新成功成功");
    }

    /**
     * 批量删除部门
     */
    @DeleteMapping("")
    public ResponseDTO handleUpdateStaff(@RequestBody Ids idsForm) {
        deptService.removeByIds(Arrays.asList(idsForm.getIds()));
        return new ResponseDTO().setCode(200).setMessage("删除成功");
    }

}
