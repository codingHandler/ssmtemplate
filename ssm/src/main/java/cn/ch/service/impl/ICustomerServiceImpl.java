package cn.ch.service.impl;

import cn.ch.mapper.CustomerMapper;
import cn.ch.entity.Customer;
import cn.ch.entity.PageBean;
import cn.ch.service.ICustomerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 客户的service层
 *
 * @author ch
 * @date 2021/5/13
 */
@Service
public class ICustomerServiceImpl implements ICustomerService {

    //注入
    @Autowired
    private CustomerMapper customerMapper;

    public void create(Customer customer) {
        customerMapper.create(customer);
    }

    public void delete(Long id) {
        customerMapper.delete(id);
    }

    public List<Customer> findAll() {
        return null;
    }

    public Customer findById(Long id) {
        return customerMapper.findById(id);
    }

    public void update(Customer customer) {
        customerMapper.update(customer);
    }

    /**
     * @return cn.ch.pojo.PageBean
     * @Author ch
     * @Description //TODO
     * @Date 2021/5/13 14:35
     * @Param customer: 查询条件
     * @Param pageCode: 当前页
     * @Param pageSize: 每页显示的记录数
     **/
    @Override
    public PageBean findByPage(Customer customer, int pageCode, int pageSize) {

        //使用Mybatis分页插件
        PageHelper.startPage(pageCode, pageSize);

        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        Page<Customer> page = customerMapper.findByPage(customer);

        return new PageBean(pageCode, (int) Math.ceil((double) (page.getTotal() / (double) pageSize)), (int) page.getTotal(), pageSize, page.getResult());
    }

//    // 分页查询的方法
//    public PageBean<Customer> findByPage(int pageCode, int pageSize, Map<String, Object> conMap) {
//        HashMap<String,Object> map = new HashMap<String,Object>();
//        PageBean<Customer> pageBean = new PageBean<Customer>();
//
//        //封装当前页
//        pageBean.setPageCode(pageCode);
//        pageBean.setPageSize(pageSize);
//
//        // 封装总记录数（从数据库中查询）
//        int totalCount = customerMapper.selectCount();
//        System.out.println("查询到的总记录数："+totalCount);
//        pageBean.setTotalCount(totalCount);
//
//        //封装总页数
//        double tc = totalCount;
//        Double num = Math.ceil(tc / pageSize);
//        pageBean.setTotalPage(num.intValue());
//
//        // 设置limit分页查询的起始位置和终止位置
//        map.put("start",(pageCode - 1) * pageSize);
//        map.put("size",pageBean.getPageSize());
//
//        //封装每页显示的数据
//        List<Customer> list = customerMapper.findByPage(map);
//        pageBean.setBeanList(list);
//
//        // 分页查询功能也要封装显示起始页和终止页
//        conMap.put("start",(pageCode - 1) * pageSize);
//        conMap.put("size",pageBean.getPageSize());
//
//        // 封装
//        List<Customer> listCondition = customerMapper.findCondition(conMap);
//        pageBean.setBeanList(listCondition);
//
//        return pageBean;
//    }


}
