# source

- https://github.com/YunaiV/onemall

# structure

## api

- rpc

  存储**app**的**rpc**类的**接口**

## app

> 以下都包含**多个文件夹**，每个实体类对应一个文件夹

- convert[kənˈvɜːt]转变

  BO**转换**为DO的各种**接口方法**

- dal.mysql 或 dal.esx

  - dataobject

    保存DO**领域**对象

  - mapper

    保存Mybatis-Plus的方法

- service

  每个实体类文件夹**又**可以包含**BO**业务对象

  每个类都**引入Mapper**

  service没有**接口**

- manager

  相当于**Controller**，每个类都**引入Service**

- rpc

  rpc接口实现类，每个类都**引入Manager**

  rpc暴露接口

**knowledge**

- app的service去除了接口
- app的**rpc**提供具体实现，web的**service**进行调用

## web

> 以下都包含**多个文件夹**，每个项目的**module**对应一个文件夹

- client

- convert

  存储**DTO**和**VO**相互转换的方法

- service

  每个类都调用某个**module**的**rpc**

- controller

  每个类都引入**service**的**Manager**







# 代码生成器

- dal.sql的dataobject：使用连接数据库，生成表名+DO的实体类

- dal.sql的mapper和：使用连接数据库，生成拥有表名的Mapper类和xml

  以上可以使用Mybatis-Plus的代码生成器，但是去除Controller和Service，且实体类添加DO

- service：使用连接数据库，生成拥有表名的不implement的Service类

- manager：使用连接数据库，生成拥有表名且添加@Service的Manager类



- Mybatis-Plus：DO和mapper移动到dataobject和mapper下的**

  生成器：在convert的***生成实体类名的Convert
  在service的***生成bo+实体类名BO，添加@Data
  在rpc的***生成dto+实体类DTO，添加@Data

  数据库实体类继承
  数据库为bit类型，把DO的Boolean改为Integer



# 实体类thingking

**实体类传递过程**

- rpc <=> manager <=> service <=> mapper

  ​             controller <=> service <=> mapper

  使用manager代替controller来操作BO

  在onemall项目上，也可以使用与manager同级别的controller，操作BO，返回VO

- 查询操作

  ReqDTO <=> (DO -> BO -> RespDTO)

- 非查询操作

  ReqDTO <=> (BO -> DO) 

  如果不用Rpc框架，一般只需要DO和BO

  而过去项目操作单表只使用DO，操作多表使用DO + BO

**各个包操作何种实体类**

- rpc接收ReqDTO 、返回RespDTO
- manager操作得到BO，返回RespDTO
- service操作得到DO，返回BO
- controller操作得到RespDTO，返回RespVO

**理想状态的实体类对象**

- DO

- BO

  操作多表

- VO

  统一前端接收数据，否则前端返回DO，而数据库表增加了字段，将导致前端多接收了该字段数据