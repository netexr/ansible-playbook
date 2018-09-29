## 使用说明
这个一个ansible playbook来做进程启停控制的示例。

### 变量说明
- group_vars中定义了应用的目录和端口，默认停止和重启都是关闭的；
- 如果要重启或停止某台主机的应用，推荐在host_vars目录中建一个主机名同名的文件进行定义；
- 判断进程是否存在是决定是否执行启动和停止的标准；
- 加了一个wait_for的模块，用于判断进程停止是否成功，如果失败任务会退出。根据实际情况来使用。

### 启动、停止与重启
```bash
# 启动应用，不加tags默认就是启动
ansible-playbook -i hosts site.yml --tags startapp

# 停止
ansible-playbook -i hosts site.yml --tags stopapp

# 重启
ansible-playbook -i hosts site.yml --tags restartapp
```