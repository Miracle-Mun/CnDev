<template>
    <div class="container">
        <div class="title">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item :to="{ path: '/' }">生产主体</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="box">
            <el-container>
                <el-table
                        :data="tableData"
                        style="width: 100%"
                        :row-class-name="rowIndex">
                    <el-table-column
                            :formatter="order"
                            label="序号"
                            width="180">
                    </el-table-column>
                    <el-table-column
                            prop="name"
                            label="企业名称">
                    </el-table-column>
                    <el-table-column
                            prop="classification"
                            label="法人代表">
                    </el-table-column>
                    <el-table-column
                            prop="type"
                            label="企业地址">
                    </el-table-column>
                    <el-table-column
                            prop="bookNo"
                            label="联系人">
                    </el-table-column>
                    <el-table-column
                            prop="date"
                            label="联系方式">
                    </el-table-column>
                    <el-table-column
                            prop="limitedPeriod"
                            label="所在乡镇">
                    </el-table-column>
                    <el-table-column
                            prop="yield"
                            label="企业诚信">
                    </el-table-column>
                    <el-table-column
                            prop="yield"goProduct
                            label="操作">
                        <template slot-scope="scope">
                            <el-tooltip class="item" effect="dark" content="修改" placement="top">
                                <el-button icon="el-icon-edit" circle @click="goEdit()"></el-button>
                            </el-tooltip>
                            <el-tooltip class="item" effect="dark" content="主营产品" placement="top">
                                <el-button icon="el-icon-warning-outline" circle @click="goProduct()"></el-button>
                            </el-tooltip>
                            <el-tooltip class="item" effect="dark" content="仓储环境" placement="top">
                                <el-button icon="el-icon-office-building" circle @click="goStorage()"></el-button>
                            </el-tooltip>
                            <el-tooltip class="item" effect="dark" content="删除" placement="top">
                                <el-button icon="el-icon-close" circle ></el-button>
                            </el-tooltip>
                        </template>
                    </el-table-column>
                </el-table>
            </el-container>
            <div class="pageBox">
                <el-pagination
                        v-if="total>page.pageSize"
                        @size-change="handleSizeChange"
                        @current-change="handleCurrentChange"
                        :current-page="page.pageIndex"
                        :page-sizes="[10, 20, 50]"
                        :page-size="page.pageSize"
                        layout="total, sizes, prev, pager, next, jumper"
                        :total="total">
                </el-pagination>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        data(){
            return{
                page:{
                    pageIndex: 1,
                    pageSize: 10
                },
                total:100,
                options:[
                    {
                        value:'全部',
                        label:''
                    }
                ],
                tableData: [
                    {
                        name: '产品',
                        classification: '分类',
                        type: '认证类型',
                        bookNo:'123456',
                        date:'2018-09-01至2020-05-01',
                        limitedPeriod:'1年',
                        yield:'600'
                    },
                    {
                        name: '产品',
                        classification: '分类',
                        type: '认证类型',
                        bookNo:'123456',
                        date:'2018-09-01至2020-05-01',
                        limitedPeriod:'1年',
                        yield:'600'
                    },
                    {
                        name: '产品',
                        classification: '分类',
                        type: '认证类型',
                        bookNo:'123456',
                        date:'2018-09-01至2020-05-01',
                        limitedPeriod:'1年',
                        yield:'600'
                    },
                    {
                        name: '产品',
                        classification: '分类',
                        type: '认证类型',
                        bookNo:'123456',
                        date:'2018-09-01至2020-05-01',
                        limitedPeriod:'1年',
                        yield:'600'
                    }
                ]
            }
        },
        methods:{
            rowIndex({row, rowIndex}) {
                row.rowIndex = rowIndex;
            },
            order(row) {
                return this.page.pageSize * (this.page.pageIndex - 1) + row.rowIndex + 1;
            },
            //分页数量改变
            handleSizeChange(val){
                let that=this
                that.page.pageSize=val;
                that.fullPage(1);
            },
            //分页索引改变
            handleCurrentChange(val){
                let that=this
                that.page.pageIndex=val
                that.fullPage(1)
            },
            //跳转添加
            goEdit(){
                this.$router.push({path: '/cp_editProduction'})
            },
            goProduct(){
                this.$router.push({path: '/cp_businessProducts'})
            },
        }
    }
</script>

<style scoped>

</style>