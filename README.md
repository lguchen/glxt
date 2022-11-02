# 基于spring boot的用户管理系统
## 使用教程
- 首先将项目克隆到本地
- 修改jdk版本保证和自己的版本一致
- 加载maven依赖
- 在application.yml文件中修改数据库连接名称和密码
- 创建数据库，并运行数据库文件加载数据
- 在Mapping.xml文件中修改相关数据库表信息
- 最后直接运行主程序即可 

## 国际化配置

- 在resources下新建i18n文件夹,并创建国际化配置文件

- login.properties中配置中文，login_en_US.properties配置英文

- 在login.html下通过thymeleaf进行参数传递，

- placeholder属性传递方式：

  ```html
  th:placeholder="#{login.pass}" //#{login.pass}指向国际化properties配置文件的内容
  ```
