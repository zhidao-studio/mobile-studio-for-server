<template>
  <div>
    <div class="simpleListStye">
      <div class="content">
        <div class="top">
          <!-- 搜索区 -->
          <div class="search">
    <%for(column in dataMap.columns){%>
        <% if (column.attrname != 'id'&& column.attrname != 'createOpr'&&column.attrname != 'dateCreate'&&column.attrname != 'modifyOpr'&&column.attrname != 'dateModify'&&column.attrname != 'isValid'&&column.attrname != 'isDelete') {%>
            ${column.comments}： <Input v-model="${column.attrname}" class="commonInput" placeholder="请输入${column.comments}"></Input>
        <%}%>
    <%}%>
             <Button type="primary" class="btn" @click="search">搜索</Button>
             <Button class="btn" @click="reset">重置</Button>
          </div>
          <div class="action">
             <Button type="primary" @click="add${dataMap.className}">新增</Button>
          </div>
      </div>
        <Table style="margin:15px;" border :columns="columns" :data="dataList"></Table>
        <Page :total="dataCount" :page-size="pageSize" :current.sync="current" show-total @on-change="changepage" @on-page-size-change="changePageSize" show-sizer class="page"></Page>
      </div>
    </div>
    <!-- 表单区 -->
    <Modal v-model="modalAddOrUpdate" width="600" :mask-closable="false" :closable="false" v-bind:title="actionType">
      <Form ref="${dataMap.classname}" :model="${dataMap.classname}" :rules="${dataMap.classname}Rule" inline>
    <%for(column in dataMap.columns){%>
        <% if (column.attrname != 'id'&& column.attrname != 'createOpr'&&column.attrname != 'dateCreate'&&column.attrname != 'modifyOpr'&&column.attrname != 'dateModify'&&column.attrname != 'isValid'&&column.attrname != 'isDelete') {%>
        <FormItem label="${column.comments}" prop="${column.attrname}" style="width:272px;">
            <Input placeholder="请输入${column.comments}" v-model="${dataMap.classname}.${column.attrname}" :maxlength="128"></Input>
        </FormItem>
        <%}%>
    <%}%>
      </Form>
      <div slot="footer">
        <Button type="default" size="large" @click="cancel('${dataMap.classname}')">取消</Button>
        <Button type="primary" size="large" @click="handleSubmitAddOrUpdate('${dataMap.classname}')">确定</Button>
      </div>
    </Modal>
  </div>
</template>

<!-- 脚本区 -->
<script>
import Res from '@/common/global'

export default {
  data () {
    return {
      id: '', // ID
     <%for(column in dataMap.columns){%>
          <% if (column.attrname != 'id'&& column.attrname != 'createOpr'&&column.attrname != 'dateCreate'&&column.attrname != 'modifyOpr'&&column.attrname != 'dateModify'&&column.attrname != 'isValid'&&column.attrname != 'isDelete') {%>
      ${column.attrname}: '', // ${column.comments}
          <%}%>
     <%}%>
      actionType: '', // 操作类型
      columns: [
        <%for(column in dataMap.columns){%>
          <% if (column.attrname != 'id'&& column.attrname != 'createOpr'&&column.attrname != 'dateCreate'&&column.attrname != 'modifyOpr'&&column.attrname != 'dateModify'&&column.attrname != 'isValid'&&column.attrname != 'isDelete') {%>
        {
          title: '${column.comments}',
          key: '${column.attrname}',
          align: 'center',
          render: (h, params) => {
            return h('div', [
              h('span', {
                style: {
                  display: 'inline-block',
                  width: '100%',
                  overflow: 'hidden',
                  textOverflow: 'ellipsis',
                  whiteSpace: 'nowrap'
                },
                domProps: {
                  title: params.row.${column.attrname}
                }
              }, params.row.${column.attrname})
            ])
          }
        },
        <%}%>
      <%}%>
        {
          title: '操作',
          key: 'operation',
          width: 200,
          align: 'center',
          render: (h, params) => {
            return h('div', [
              h('Button', {
                props: {
                  type: 'warning',
                  size: 'small'
                },
                style: {
                  marginRight: '5px'
                },
                on: {
                  click: () => {
                    this.update${dataMap.className}(params.index)
                  }
                }
              }, '修改'),
              h('Button', {
                props: {
                  type: 'error',
                  size: 'small'
                },
                style: {
                  marginRight: '5px'
                },
                on: {
                  click: () => {
                    this.handleSubmitDelete(params.index)
                  }
                }
              }, '删除')
            ])
          }
        }
      ],
      dataList: [], // 当前显示的数据
      dataCount: 0, // 初始化信息总条数
      current: 1,
      pageSize: 10, // 每页显示多少条
      pageNum: 1, // 当前显示页数
      modalAddOrUpdate: false, // 是否显示新增弹窗
      ${dataMap.classname}: { // 实体
      <%for(column in dataMap.columns){%>
          <% if (column.attrname != 'id'&& column.attrname != 'createOpr'&&column.attrname != 'dateCreate'&&column.attrname != 'modifyOpr'&&column.attrname != 'dateModify'&&column.attrname != 'isValid'&&column.attrname != 'isDelete') {%>
        ${column.attrname}: '', // ${column.comments}
          <%}%>
      <%}%>
      },
      ${dataMap.classname}Rule: {
      <%for(column in dataMap.columns){%>
          <% if (column.attrname != 'id'&& column.attrname != 'createOpr'&&column.attrname != 'dateCreate'&&column.attrname != 'modifyOpr'&&column.attrname != 'dateModify'&&column.attrname != 'isValid'&&column.attrname != 'isDelete') {%>
        ${column.attrname}: [
          {required: true, message: '${column.comments}不能为空', trigger: 'blur'}
        ],
          <%}%>
      <%}%>
      }
    }
  },
  methods: {
    handleSubmitAddOrUpdate (name) { // 提交新增或修改操作
      this.$refs[name].validate((valid) => {
        if (valid) {
          this.loading.start()
          this.httpRequest({
            method: 'POST',
            url: '/v1/${dataMap.classname}',
            data: {
              id: this.id,
              <%for(column in dataMap.columns){%>
                <% if (column.attrname != 'id'&& column.attrname != 'createOpr'&&column.attrname != 'dateCreate'&&column.attrname != 'modifyOpr'&&column.attrname != 'dateModify'&&column.attrname != 'isValid'&&column.attrname != 'isDelete') {%>
              ${column.attrname}: this.${dataMap.classname}.${column.attrname},
                <%}%>
              <%}%>
            }
          })
            .then(res => {
              if (res.data.code === Res.SUCCESS) {
                this.$Message.success('成功！')
                this.$refs['${dataMap.classname}'].resetFields()
                this.modalAddOrUpdate = false
                this.reset()
              } else {
                this.$Message.error(res.data.message)
              }
              this.loading.end()
            })
            .catch(e => {
              this.$Message.error(e)
              this.loading.end()
            })
        } else {
          this.$Message.error('请检查参数是否填写完整!')
        }
      })
    },
    handleSubmitDelete (index) { // 提交删除按钮
      if (confirm('确认要删除此配置吗？')) {
        this.httpRequest({
          method: 'DELETE',
          url: '/v1/${dataMap.classname}/' + this.dataList[index].id
        })
          .then(response => {
            this.responseData = response.data
            if (this.responseData.code === Res.ERROR) {
              this.$Message.error(response.data.message)
            } else {
              this.$Message.success('删除成功！')
            }
            this.search()
          })
      }
    },
    search () { // (支持分页)
      this.loading.start()
      this.httpRequest({
        method: 'POST',
        url: '/v1/${dataMap.classname}/pageList',
        data: {
        <%for(column in dataMap.columns){%>
          <% if (column.attrname != 'id'&& column.attrname != 'createOpr'&&column.attrname != 'dateCreate'&&column.attrname != 'modifyOpr'&&column.attrname != 'dateModify'&&column.attrname != 'isValid'&&column.attrname != 'isDelete') {%>
          ${column.attrname}: this.${column.attrname},
          <%}%>
        <%}%>
          pageNum: this.pageNum,
          pageSize: this.pageSize
        }
      })
        .then(res => {
          if (res.data.code === Res.SUCCESS) {
            let data = res.data.data
            this.dataCount = data.totalAmount
            this.dataList = data.resultList
          } else if (res.data.code === Res.ERROR) {
            this.$Message.error(res.data.message)
          }
          this.loading.end()
        })
        .catch(e => {
          this.$Message.error(e)
          this.loading.end()
        })
    },
    // 重置查询
    reset () {
     <%for(column in dataMap.columns){%>
        <% if (column.attrname != 'id'&& column.attrname != 'createOpr'&&column.attrname != 'dateCreate'&&column.attrname != 'modifyOpr'&&column.attrname != 'dateModify'&&column.attrname != 'isValid'&&column.attrname != 'isDelete') {%>
      this.${column.attrname} = ''
        <%}%>
     <%}%>
      this.pageNum = 1
      this.current = 1
      this.search()
    },
    add${dataMap.className} () { // 点击新增按钮
      this.actionType = '新增'
      this.modalAddOrUpdate = true
      this.id = ''
    },
    update${dataMap.className} (index) { // 点击更新按钮
      this.id = this.dataList[index].id
      this.actionType = '修改'
  <%for(column in dataMap.columns){%>
      <% if (column.attrname != 'id'&& column.attrname != 'createOpr'&&column.attrname != 'dateCreate'&&column.attrname != 'modifyOpr'&&column.attrname != 'dateModify'&&column.attrname != 'isValid'&&column.attrname != 'isDelete') {%>
      this.${dataMap.classname}.${column.attrname} = this.dataList[index].${column.attrname}
      <%}%>
  <%}%>
      this.modalAddOrUpdate = true
    },
    changepage (index) { // 切换到别的页
      this.pageNum = index
      this.search()
    },
    changePageSize (pageSize) {
      this.pageSize = pageSize
      this.search()
    },
    cancel (name) { // 取消新增
      this.$refs[name].resetFields()
      this.modalAddOrUpdate = false
    }

  },
  mounted () {
    this.search() // 在查询动态表单之前，一定要先获取模板类型下拉列表，因为数据库存的是编码，列表中的模板类型名称需要通过模板类型列表来比对后转换为对应中文
  }
}
</script>

<!-- 样式区 -->
<style lang="less" scoped>
  .simpleListStye {
    height: calc(100% - 24px);
    margin: 0 24px 0px 24px;
    border-radius: 2px;

    .header {
      margin-top: 24px;
      background-color: #fff;

      .title {
        height: 55px;
        width: 100%;
        color: #333;
        font-size: 16px;
        line-height: 55px;
        padding: 0 0 0 32px;
        border-bottom: 1px solid #e9e9e9;
        font-weight: 500;
      }

      .status {
        height: 55px;
        display: flex;
        flex-flow: row;
        padding: 0 32px;
        line-height: 55px;

        ul {
          display: flex;
          flex-flow: row;

          li {
            margin-left: 20px;
            display: inline-block;
            height: 20px;
            line-height: 20px;
            margin-top: 17px;
            padding: 0 5px;
            cursor: pointer;
          }

          .active {
            background-color: #0080ff;
            color: #fff;
            font-weight: 500;
            border-radius: 4px;
          }
        }
      }
    }

    .content {
      margin-top: 24px;
      background-color: #fff;
      border-radius: 2px;
      padding-bottom: 24px;

      .btn {
        margin-left: 20px;
      }

      .top {
        padding: 20px 10px 10px 20px;

        .action {
          padding-top: 20px;
        }
      }

      .dataTable {
        margin: 20px;
      }

      .page {
        text-align: center;
      }
    }
  }
</style>
