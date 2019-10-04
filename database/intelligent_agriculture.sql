-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 02, 2019 at 12:42 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `intelligent_agriculture`
--

-- --------------------------------------------------------

--
-- Table structure for table `blacklist`
--

CREATE TABLE `blacklist` (
  `BLACKLIST_ID` int(11) NOT NULL COMMENT '红黑ID',
  `CREDITCODE` varchar(50) NOT NULL COMMENT '统一社会信用代码',
  `BLACKLIST_TYPE` varchar(20) NOT NULL COMMENT '红黑类型 (1:红名单, 2:黑名单)',
  `NOW_GRADE` varchar(20) DEFAULT NULL COMMENT '现信用评级（A:守信， B:基本守信，C:失信）',
  `GRADE_TIME` datetime DEFAULT NULL COMMENT '评级时间',
  `GRADE_UNIT` varchar(50) NOT NULL COMMENT '评级单位名称',
  `GRADE_UNIT_ID` varchar(20) NOT NULL COMMENT '评级单位ID',
  `APPROVAL_STATUS` varchar(20) NOT NULL DEFAULT '0' COMMENT '审批状态（0：正常，1：待审批 ，2：已审批）',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='红黑名单' ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `blacklist`
--

INSERT INTO `blacklist` (`BLACKLIST_ID`, `CREDITCODE`, `BLACKLIST_TYPE`, `NOW_GRADE`, `GRADE_TIME`, `GRADE_UNIT`, `GRADE_UNIT_ID`, `APPROVAL_STATUS`, `CREATE_TIME`, `CREATE_USER_ID`, `UPDATE_TIME`, `UPDATE_USER_ID`) VALUES
(0, 'CODE1', '1', 'A', '2019-09-27 01:53:48', '梅李镇农产品质量安全监管站', 'UNITCODE1', '0', '2019-09-27 01:53:48', 1, '2019-09-27 01:53:48', 1),
(0, 'CODE1', '1', 'A', '2019-09-27 01:54:17', '梅李镇农产品质量安全监管站', 'UNITCODE1', '0', '2019-09-27 01:54:17', 1, '2019-09-27 01:54:17', 1),
(0, 'CODE1', '1', 'B', '2019-09-27 01:54:17', '梅李镇农产品质量安全监管站', 'UNITCODE1', '1', '2019-09-27 01:54:17', 1, '2019-09-27 01:54:17', 1),
(0, 'CODE1', '1', 'B', '2019-09-27 01:54:17', '梅李镇农产品质量安全监管站', 'UNITCODE1', '2', '2019-09-27 01:54:17', 1, '2019-09-27 01:54:17', 1),
(0, 'CODE1', '1', 'C', '2019-09-27 01:54:17', '梅李镇农产品质量安全监管站', 'UNITCODE1', '0', '2019-09-27 01:54:17', 1, '2019-09-27 01:54:17', 1),
(0, 'CODE1', '1', 'C', '2019-09-27 01:54:17', '梅李镇农产品质量安全监管站', 'UNITCODE1', '0', '2019-09-27 01:54:17', 1, '2019-09-27 01:54:17', 1);

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `ID` bigint(20) NOT NULL,
  `PROVINCE_ID` bigint(20) NOT NULL,
  `NAME` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`ID`, `PROVINCE_ID`, `NAME`) VALUES
(0, 4, '江苏直属'),
(0, 6, '江苏省直属'),
(1, 4, '苏州'),
(1, 6, '苏州市'),
(2, 6, '常熟市');

-- --------------------------------------------------------

--
-- Table structure for table `company_business`
--

CREATE TABLE `company_business` (
  `COMPANY_ID` int(11) NOT NULL COMMENT '经营主体ID',
  `COMPANY_NAME` varchar(50) DEFAULT NULL COMMENT '企业名称',
  `COMPANY_SCALE` varchar(11) DEFAULT NULL COMMENT '企业规模(1:小型企业,2:中型企业,3:大型企业)',
  `PRODUCT_TYPE` varchar(11) DEFAULT NULL COMMENT '产品类型(1:农药, 2:种子, 3:饲料, 4:肥料))',
  `LEGAL_PERSON` varchar(50) DEFAULT NULL COMMENT '法定代表人',
  `COMPANY_ADDRESS` varchar(255) DEFAULT NULL COMMENT '企业地址',
  `CREDIT_CODE` varchar(255) NOT NULL COMMENT '行政相对人代码_1 (统一社会信用代码)',
  `CONTACT_WAY` varchar(255) DEFAULT NULL COMMENT '联系方式 : (COMPANY_TYPE=2 农户)',
  `SUPERVISION_NATURE` varchar(255) DEFAULT NULL COMMENT '监管对象性质(1:法人,2:其他组织)',
  `COMPANY_PROFILE` varchar(255) DEFAULT NULL COMMENT '公司简介',
  `PROFILE_IMAGE` varchar(255) NOT NULL COMMENT '作业图片',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='经营主体' ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `company_credit_grade`
--

CREATE TABLE `company_credit_grade` (
  `CREDIT_GRADE_ID` int(11) NOT NULL COMMENT '企业信用评级ID',
  `CREDITCODE` varchar(50) NOT NULL COMMENT '统一社会信用代码',
  `ORIGINAL_GRADE` varchar(20) NOT NULL COMMENT '原信用评级（A:守信， B:基本守信，C:失信）',
  `NOW_GRADE` varchar(20) DEFAULT NULL COMMENT '现信用评级',
  `APPROVAL_GRADE` varchar(20) DEFAULT NULL COMMENT '待审批信用评级',
  `GRADE_TIME` datetime DEFAULT NULL COMMENT '评级时间',
  `GRADE_UNIT` varchar(50) NOT NULL COMMENT '评级单位名称',
  `GRADE_UNIT_ID` varchar(20) NOT NULL COMMENT '评级单位ID',
  `APPROVAL_STATUS` varchar(20) NOT NULL DEFAULT '0' COMMENT '审批状态（0：已拒绝，1：待审批 ，2：已审批）',
  `FILES` varchar(255) NOT NULL COMMENT '附件',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业信用评级' ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `company_credit_grade`
--

INSERT INTO `company_credit_grade` (`CREDIT_GRADE_ID`, `CREDITCODE`, `ORIGINAL_GRADE`, `NOW_GRADE`, `APPROVAL_GRADE`, `GRADE_TIME`, `GRADE_UNIT`, `GRADE_UNIT_ID`, `APPROVAL_STATUS`, `FILES`, `CREATE_TIME`, `CREATE_USER_ID`, `UPDATE_TIME`, `UPDATE_USER_ID`) VALUES
(1, 'CODE1', 'B', 'A', 'A', '2019-09-27 00:00:00', '梅李镇农产品质量安全监管站', 'UNITCODE1', '1', '', '2019-09-27 01:49:26', 1, '2019-09-27 01:49:26', 1),
(2, 'CODE1', 'B', 'A', 'A', '2019-09-27 00:00:00', '梅李镇农产品质量安全监管站', 'UNITCODE1', '2', '', '2019-09-27 01:50:09', 1, '2019-09-27 01:50:09', 1),
(3, 'CODE1', 'B', 'A', 'A', '2019-09-27 00:00:00', '梅李镇农产品质量安全监管站', 'UNITCODE1', '2', '', '2019-09-27 01:50:09', 1, '2019-09-27 01:50:09', 1),
(4, 'CODE1', 'B', 'A', 'A', '2019-09-27 00:00:00', '梅李镇农产品质量安全监管站', 'UNITCODE1', '0', '', '2019-09-27 01:50:09', 1, '2019-09-27 01:50:09', 1);

-- --------------------------------------------------------

--
-- Table structure for table `company_production`
--

CREATE TABLE `company_production` (
  `COMPANY_ID` int(11) NOT NULL COMMENT '生产主体ID',
  `CREDIT_CODE` varchar(50) NOT NULL COMMENT '行政相对人代码_1 (统一社会信用代码)',
  `COMPANY_TYPE` varchar(50) NOT NULL COMMENT '生产主体类型(1:企业 2：农户)',
  `TOWN_ID` int(11) DEFAULT NULL COMMENT '乡镇ID',
  `AGRICULTURAL_CLASSIFICATION` varchar(255) DEFAULT NULL COMMENT '农业分类(1:养殖业，2：畜牧业，3：种植业)',
  `COMPANY_NAME` varchar(50) DEFAULT NULL COMMENT '单位名称',
  `CHARGE_PERSON` varchar(50) DEFAULT NULL COMMENT '负责人(农户姓名)',
  `CONTACT_WAY` varchar(255) DEFAULT NULL COMMENT '联系方式 : (COMPANY_TYPE=2 农户)',
  `PLANT_AREA` decimal(10,0) DEFAULT NULL COMMENT '种养殖面积(亩) : (COMPANY_TYPE=2 农户)',
  `LAND_SOURCE` varchar(255) DEFAULT NULL COMMENT '土地来源 : (COMPANY_TYPE=2 农户)',
  `COMPANY_ADDRESS` varchar(50) DEFAULT NULL COMMENT '地址',
  `PRODUCT_INFO` varchar(2000) DEFAULT NULL COMMENT '生产主体产品信息 ({planting : {name:xxx, area:10}, aquatic : {name:xxx, area:10}, livestock : {name:xxx, area:10}, poultry : {name:xxx, area:10}})',
  `QUALITY_STANDARD_ID` int(11) DEFAULT NULL COMMENT '三品认证ID : quality_standard',
  `CONTACT_PERSON` varchar(50) DEFAULT NULL COMMENT '联系人',
  `CONTACT_MOBILE` varchar(32) DEFAULT NULL COMMENT '联系人手机',
  `COMPANY_HONOR` varchar(255) DEFAULT NULL COMMENT '企业荣誉',
  `REMARKS` varchar(255) DEFAULT NULL COMMENT '备注',
  `DO_SUPERVISION` varchar(50) DEFAULT NULL COMMENT '是否监管(0:否,1:是)',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生产主体' ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `company_production`
--

INSERT INTO `company_production` (`COMPANY_ID`, `CREDIT_CODE`, `COMPANY_TYPE`, `TOWN_ID`, `AGRICULTURAL_CLASSIFICATION`, `COMPANY_NAME`, `CHARGE_PERSON`, `CONTACT_WAY`, `PLANT_AREA`, `LAND_SOURCE`, `COMPANY_ADDRESS`, `PRODUCT_INFO`, `QUALITY_STANDARD_ID`, `CONTACT_PERSON`, `CONTACT_MOBILE`, `COMPANY_HONOR`, `REMARKS`, `DO_SUPERVISION`, `CREATE_TIME`, `CREATE_USER_ID`, `UPDATE_TIME`, `UPDATE_USER_ID`) VALUES
(1, 'CODE1', '1', 1, '1', '稻米专业合作社', '程晓刚', NULL, NULL, NULL, '地址', '{planting : {name:xxx, area:10}, aquatic : {name:xxx, area:10}, livestock : {name:xxx, area:10}, poultry : {name:xxx, area:10}}', NULL, '程晓刚', '52380296', '企业荣誉	', '备注', '1', '2019-09-27 01:42:11', 1, '2019-09-27 01:42:11', 1),
(2, 'CODE2', '1', 1, '1', '稻米专业合作社', '程晓刚', NULL, NULL, NULL, '地址', '{planting : {name:xxx, area:10}, aquatic : {name:xxx, area:10}, livestock : {name:xxx, area:10}, poultry : {name:xxx, area:10}}', NULL, '程晓刚', '52380296', '企业荣誉	', '备注', '1', '2019-09-27 01:42:11', 1, '2019-09-27 01:42:11', 1);

-- --------------------------------------------------------

--
-- Table structure for table `county`
--

CREATE TABLE `county` (
  `ID` bigint(20) NOT NULL,
  `PROVINCE_ID` bigint(20) NOT NULL,
  `CITY_ID` bigint(20) NOT NULL,
  `NAME` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `county`
--

INSERT INTO `county` (`ID`, `PROVINCE_ID`, `CITY_ID`, `NAME`) VALUES
(0, 4, 1, '苏州直属'),
(0, 6, 1, '苏州市直属'),
(0, 6, 2, '常熟市直属'),
(1, 4, 1, '常熟'),
(1, 6, 1, '常熟市');

-- --------------------------------------------------------

--
-- Table structure for table `disability_check`
--

CREATE TABLE `disability_check` (
  `ID` int(11) NOT NULL COMMENT '农残检测ID',
  `NO` varchar(32) NOT NULL COMMENT '编号',
  `CHANNEL` varchar(18) NOT NULL COMMENT '通道，孔位',
  `CREDIT_CODE` varchar(64) NOT NULL COMMENT '行政相对人代码_1 (统一社会信用代码)	',
  `ITEM` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '检测项目名称',
  `ITEM_EN` varchar(64) NOT NULL COMMENT '检测项目项目英文名',
  `SAMPLE` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '样品名称',
  `SAMPLE_CLASS` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '样品类型',
  `SOURCE` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '来源单位',
  `SOURCE_PIC` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '来源单位负责人',
  `ABS_1` decimal(10,2) NOT NULL COMMENT '第一次吸光度',
  `ABS_2` decimal(10,2) NOT NULL COMMENT '第二次吸光度',
  `RESULT_DL` decimal(10,2) NOT NULL COMMENT '定量结果',
  `RESULT_DX` tinyint(1) NOT NULL COMMENT '定性结果 *  1合格 0不合格 2疑似',
  `RESULT_DX_DESC` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '定性结果的中文表述',
  `RESULT_UNIT` varchar(8) CHARACTER SET utf8 NOT NULL COMMENT '单位',
  `DETECT_PLACE` varchar(256) CHARACTER SET utf8 NOT NULL COMMENT '检测地点',
  `DETECT_TIME` datetime NOT NULL COMMENT '检测时间',
  `DETECT_UNIT` varchar(128) CHARACTER SET utf8 NOT NULL COMMENT '检测单位',
  `OPERATOR` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '检测员',
  `REAGENT` varchar(128) CHARACTER SET utf8 NOT NULL COMMENT '试剂',
  `REAGENT_COP` varchar(128) CHARACTER SET utf8 NOT NULL COMMENT '试剂公司',
  `INSTRUMENT` varchar(64) CHARACTER SET utf8 NOT NULL COMMENT '仪器',
  `INSTRUMENT_COP` varchar(128) CHARACTER SET utf8 NOT NULL COMMENT '仪器公司',
  `DETECT_UNIT_ID` varchar(32) NOT NULL COMMENT '检测单位编号'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `disability_check`
--

INSERT INTO `disability_check` (`ID`, `NO`, `CHANNEL`, `CREDIT_CODE`, `ITEM`, `ITEM_EN`, `SAMPLE`, `SAMPLE_CLASS`, `SOURCE`, `SOURCE_PIC`, `ABS_1`, `ABS_2`, `RESULT_DL`, `RESULT_DX`, `RESULT_DX_DESC`, `RESULT_UNIT`, `DETECT_PLACE`, `DETECT_TIME`, `DETECT_UNIT`, `OPERATOR`, `REAGENT`, `REAGENT_COP`, `INSTRUMENT`, `INSTRUMENT_COP`, `DETECT_UNIT_ID`) VALUES
(1, 'NCKJ102939', '6', '', '农药残留', 'NCYL', '青菜', '叶菜类', '东青村', '计冬', '0.15', '0.28', '24.00', 1, '合格', '%', '虞山镇政府', '2019-09-27 02:22:07', '虞山镇农服中心', '金晓峰', '农残速测试剂', '广东绿健', '农残速测仪 HN2600', '苏州慧康科技有限公司', '160101'),
(2, 'NCKJ102940', '6', '', '克伦特罗', 'Cal', '鸡肉', '肉类', '东青村', '计冬', '72.04', '84.54', '0.85', 1, '合格', '%', '虞山镇政府', '2019-09-27 02:31:03', '虞山镇农服中心', '金晓峰', '克伦特罗胶体金检测卡', '无锡中德生物', '手持式胶体金检测仪 HJ3000', '苏州慧康科技有限公司', '160101');

-- --------------------------------------------------------

--
-- Table structure for table `inputs_purchase`
--

CREATE TABLE `inputs_purchase` (
  `INPUTS_ID` int(11) NOT NULL COMMENT '投入品ID',
  `COMPANY_ID` int(11) NOT NULL COMMENT '生产主体ID',
  `SAMPLE_NAME` varchar(255) DEFAULT NULL COMMENT '样品名称',
  `AMOUNT` decimal(10,2) DEFAULT NULL COMMENT '采购数量',
  `INPUT_PROFILES` varchar(1000) DEFAULT NULL COMMENT '投入品附件',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投入品-采购信息' ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `inputs_use`
--

CREATE TABLE `inputs_use` (
  `INPUTS_ID` int(11) NOT NULL COMMENT '投入品ID',
  `COMPANY_ID` int(11) NOT NULL COMMENT '生产主体ID',
  `SAMPLE_NAME` varchar(255) DEFAULT NULL COMMENT '样品名称',
  `AMOUNT` decimal(10,2) DEFAULT NULL COMMENT '使用数量',
  `INPUT_PROFILES` varchar(1000) DEFAULT NULL COMMENT '投入品附件',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='投入品-使用信息' ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `notice`
--

CREATE TABLE `notice` (
  `NOTICE_ID` int(11) NOT NULL COMMENT '公告ID',
  `RELEASE_TIME` datetime DEFAULT NULL COMMENT '发布日期',
  `RELEASE_PERSON` varchar(50) DEFAULT NULL COMMENT '发布人',
  `TITLE` varchar(255) DEFAULT NULL COMMENT '标题',
  `CONTENT` varchar(500) DEFAULT NULL COMMENT '内容',
  `NOTICE_PROFILES` varchar(1000) DEFAULT NULL COMMENT '公告附件',
  `EMERGENCY_DEGREE` varchar(255) DEFAULT NULL COMMENT '紧急程度(1:低,2:中,3:高)',
  `TYPE` varchar(255) DEFAULT NULL COMMENT '类型',
  `TIMING_RELEASE` varchar(255) DEFAULT NULL COMMENT '定时发布',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告' ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `notice_note_record`
--

CREATE TABLE `notice_note_record` (
  `NOTE_RECORD_ID` int(11) NOT NULL COMMENT '短信记录ID',
  `NOTICE_ID` int(11) NOT NULL COMMENT '公告ID',
  `NOTE_CONTENT` varchar(1000) DEFAULT NULL COMMENT '短信内容',
  `SEND_TIME` datetime DEFAULT NULL COMMENT '发送时间',
  `SEND_PERSON` varchar(255) DEFAULT NULL COMMENT '发送人',
  `SEND_RESULT` varchar(11) DEFAULT NULL COMMENT '发送结果(0:失败,1:成功)',
  `SEND_AMOUNT` int(255) DEFAULT NULL COMMENT '发送数量',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告-短信记录' ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `pesticide_check`
--

CREATE TABLE `pesticide_check` (
  `CHECK_ID` int(11) NOT NULL COMMENT '农残检测ID',
  `CHECK_NO` int(11) DEFAULT NULL COMMENT '编号',
  `CHECK_NAME` varchar(255) DEFAULT NULL COMMENT '检测项目',
  `SPECIMEN` varchar(255) DEFAULT NULL COMMENT '样品',
  `SOURCE` varchar(255) DEFAULT NULL COMMENT '来源',
  `QUANTITATIVE_RESULT` decimal(9,6) DEFAULT NULL COMMENT '定量结果',
  `QUALITATIVE_RESULT` varchar(255) DEFAULT NULL COMMENT '定性结果(1:阴性,2:阳性)',
  `CHECK_TIME` datetime DEFAULT NULL COMMENT '检测时间',
  `CHECK_ORGANIZATION` varchar(255) DEFAULT NULL COMMENT '检测单位',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='农残检测' ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `production_records`
--

CREATE TABLE `production_records` (
  `PRODUCTION_RECORDS_ID` int(11) NOT NULL COMMENT '生产记录ID',
  `PRODUCT_ID` int(11) NOT NULL COMMENT '产品ID',
  `PRODUCT_NAME` varchar(50) DEFAULT NULL COMMENT '产品名称',
  `PRODUCTION_QUANTITY` decimal(10,2) DEFAULT NULL COMMENT '产量',
  `PRODUCTION_AREA` varchar(255) DEFAULT NULL COMMENT '产地',
  `PRODUCTION_TIME` decimal(10,2) DEFAULT NULL COMMENT '生产时长',
  `PRODUCTION_PROFILES` varchar(500) DEFAULT NULL COMMENT '生产记录附件',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生产记录' ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `production_standard`
--

CREATE TABLE `production_standard` (
  `PRODUCTION_STANDARD_ID` int(11) NOT NULL COMMENT '生产标准ID',
  `PRODUCT_NAME` varchar(50) DEFAULT NULL COMMENT '产品名称',
  `CATEGORY` varchar(11) DEFAULT NULL COMMENT '类别(1:畜牧业,2:水产业)',
  `RELEASE_TIME` datetime DEFAULT NULL COMMENT '发布日期',
  `RELEASE_PERSON` varchar(50) DEFAULT NULL COMMENT '发布人',
  `PRODUCTION_STANDARD` varchar(1000) DEFAULT NULL COMMENT '生产标准',
  `PRODUCTION_STANDARD_PROFILES` varchar(1000) DEFAULT NULL COMMENT '生产标准附件',
  `PRODUCT_ID` int(11) DEFAULT NULL COMMENT '产品ID',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生产标准' ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `product_batch`
--

CREATE TABLE `product_batch` (
  `PRODUCT_BATCH_ID` int(11) NOT NULL COMMENT '产品批次ID',
  `VARIETY` varchar(11) DEFAULT NULL COMMENT '品种',
  `GRADE` varchar(11) DEFAULT NULL COMMENT '等级名称',
  `PRODUCT_ID` int(11) NOT NULL COMMENT '产品ID : product_production',
  `PROPERTY_ID` int(11) NOT NULL COMMENT '属性ID : product_property',
  `PROPERTY_NAME` varchar(50) NOT NULL COMMENT '属性名称	: product_property->PROPERTY_NAME',
  `PROPERTY_OPTION` varchar(50) NOT NULL COMMENT '属性项 : product_property->PROPERTY_OPTIONS',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生产主体-产品批次' ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `product_business`
--

CREATE TABLE `product_business` (
  `PRODUCT_ID` int(11) NOT NULL COMMENT '产品ID',
  `PRODUCT_NAME` varchar(50) DEFAULT NULL COMMENT '产品名称',
  `ATUNITPRICE` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `PRODUCT_AREA` varchar(255) DEFAULT NULL COMMENT '产地',
  `VARIETY` varchar(11) DEFAULT NULL COMMENT '品种',
  `SPECIFICATION` varchar(11) DEFAULT NULL COMMENT '规格',
  `GRADE` varchar(11) DEFAULT NULL COMMENT '评级',
  `COMPANY_ID` int(11) NOT NULL COMMENT '经营主体ID : company_business',
  `PRODUCT_PROFILE` varchar(500) DEFAULT NULL COMMENT '产品介绍',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='经营主体-经营产品' ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `product_check_record`
--

CREATE TABLE `product_check_record` (
  `PRODUCT_CHECK_RECORD_ID` int(11) NOT NULL COMMENT '第三方抽检记录ID',
  `PRODUCT_CHECK_TIME` datetime DEFAULT NULL COMMENT '抽检时间',
  `SPECIMEN` varchar(50) DEFAULT NULL COMMENT '样品',
  `CHECK_ITEM` varchar(255) DEFAULT NULL COMMENT '检测项目',
  `CHECK_RESULT` varchar(255) DEFAULT NULL COMMENT '检测结果(1:阴性,2:阳性)',
  `DETERMINE` varchar(255) DEFAULT NULL COMMENT '判定(1:合格,0:不合格)',
  `CHECK_STANDARD` varchar(255) DEFAULT NULL COMMENT '检测标准',
  `CHECK_ORGANIZATION` varchar(255) DEFAULT NULL COMMENT '检测机构',
  `PRODUCT_ID` int(11) NOT NULL COMMENT '产品ID : product_production',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生产主体-第三方抽检记录' ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `product_examining_report`
--

CREATE TABLE `product_examining_report` (
  `EXAMINING_REPORT_ID` int(11) NOT NULL COMMENT '检测报告ID',
  `PRODUCT_BATCH_ID` int(11) NOT NULL COMMENT '产品批次ID : product_batch	',
  `REPORT_TIME` datetime DEFAULT NULL COMMENT '报告日期',
  `REPORT_PROFILES` varchar(1000) DEFAULT NULL COMMENT '报告文件',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生产主体-检测报告' ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `product_grade`
--

CREATE TABLE `product_grade` (
  `GRADE_ID` int(11) NOT NULL COMMENT '等级ID',
  `GRADE_NAME` varchar(255) DEFAULT NULL COMMENT '等级名称',
  `GRADE_SORT` varchar(255) DEFAULT NULL COMMENT '等级排序',
  `PRODUCT_ID` int(11) DEFAULT NULL COMMENT '产品ID : product_production',
  `DO_SHARE` varchar(255) NOT NULL COMMENT '是否共享(0:否，1：是)',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生产主体-定义等级' ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `product_production`
--

CREATE TABLE `product_production` (
  `PRODUCT_ID` bigint(11) NOT NULL COMMENT '产品ID',
  `PRODUCT_NAME` varchar(50) DEFAULT NULL COMMENT '产品名称',
  `DO_ORGANIC` varchar(11) DEFAULT NULL COMMENT '是否为有机产品(0:否,1:是)',
  `ATUNITPRICE` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `PRODUCT_AREA` varchar(255) DEFAULT NULL COMMENT '产地',
  `VARIETY` varchar(11) DEFAULT NULL COMMENT '品种',
  `SPECIFICATION` varchar(11) DEFAULT NULL COMMENT '规格',
  `GRADE` varchar(11) DEFAULT NULL COMMENT '评级',
  `COMPANY_ID` int(11) NOT NULL COMMENT '生产主体ID : company_production',
  `PRODUCT_PROFILE` varchar(500) DEFAULT NULL COMMENT '产品介绍',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生产主体-主营产品' ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `product_production`
--

INSERT INTO `product_production` (`PRODUCT_ID`, `PRODUCT_NAME`, `DO_ORGANIC`, `ATUNITPRICE`, `PRODUCT_AREA`, `VARIETY`, `SPECIFICATION`, `GRADE`, `COMPANY_ID`, `PRODUCT_PROFILE`, `CREATE_TIME`, `CREATE_USER_ID`, `UPDATE_TIME`, `UPDATE_USER_ID`) VALUES
(1, '银针', '1', '200.00', '福建福鼎点头镇', '白茶', '规格', '特级', 1, '产品介绍	', '2019-09-27 01:45:06', 1, '2019-09-27 01:45:06', 1);

-- --------------------------------------------------------

--
-- Table structure for table `product_property`
--

CREATE TABLE `product_property` (
  `PROPERTY_ID` int(11) NOT NULL COMMENT '属性ID',
  `PROPERTY_NAME` varchar(50) DEFAULT NULL COMMENT '属性名称',
  `PROPERTY_OPTIONS` varchar(255) DEFAULT NULL COMMENT '属性可选项 : {value1, value2, value3}',
  `PROPERTY_SORT` varchar(255) DEFAULT NULL COMMENT '属性排序',
  `PRODUCT_ID` int(11) DEFAULT NULL COMMENT '产品ID : product_production',
  `DO_SHARE` varchar(11) NOT NULL COMMENT '是否共享(0:否，1：是)',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生产主体-属性管理' ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `product_repertory`
--

CREATE TABLE `product_repertory` (
  `REPERTORY_ID` int(11) NOT NULL COMMENT '库存动态ID',
  `REPERTORY_AMOUNT` decimal(10,2) DEFAULT NULL COMMENT '数量',
  `VARIETY` varchar(255) DEFAULT NULL COMMENT '品种',
  `GRADE` varchar(11) DEFAULT NULL COMMENT '等级(1:低级,2:中级,3:高级,4:特级)',
  `PRODUCT_ID` int(11) NOT NULL COMMENT '产品ID : product_production',
  `WAREHOUSE_ID` int(11) NOT NULL COMMENT '仓库ID : warehouse',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生产主体-库存动态' ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `product_sale`
--

CREATE TABLE `product_sale` (
  `PRODUCT_SALE_ID` int(11) NOT NULL COMMENT '销售ID',
  `PRODUCT_BATCH_ID` int(11) NOT NULL COMMENT '产品批次ID : product_batch',
  `SALE_DIRECTION` varchar(255) DEFAULT NULL COMMENT '销售去向',
  `SALE_TIME` datetime DEFAULT NULL COMMENT '销售日期',
  `SALE_PROFILES` varchar(1000) DEFAULT NULL COMMENT '销售文件',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生产主体-销售' ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `product_task`
--

CREATE TABLE `product_task` (
  `TASK_ID` int(11) NOT NULL COMMENT '作业ID',
  `PRODUCT_BATCH_ID` int(11) NOT NULL COMMENT '产品批次ID : product_batch',
  `TASK_NAME` varchar(50) DEFAULT NULL COMMENT '作业名称',
  `TASK_TYPE` varchar(11) DEFAULT NULL COMMENT '作业类型(1:收获前,2:收获,3:收获后)',
  `TASK_IMAGES` varchar(1000) DEFAULT NULL COMMENT '作业图片',
  `PRODUCT_ID` int(11) DEFAULT NULL COMMENT '产品ID : product_production',
  `DO_SHARE` varchar(11) NOT NULL COMMENT '是否共享(0:否，1：是)',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生产主体-作业定义' ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `product_variety`
--

CREATE TABLE `product_variety` (
  `VARIETY_ID` int(11) NOT NULL COMMENT '品种ID',
  `VARIETY_NAME` varchar(255) DEFAULT NULL COMMENT '品种名称',
  `VARIETY_SORT` varchar(255) DEFAULT NULL COMMENT '品种排序',
  `PRODUCT_ID` int(11) DEFAULT NULL COMMENT '产品ID : product_production',
  `DO_SHARE` varchar(11) DEFAULT NULL COMMENT '是否共享(0:否，1：是)',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='品种定义' ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `province`
--

CREATE TABLE `province` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `province`
--

INSERT INTO `province` (`ID`, `NAME`) VALUES
(4, '江苏'),
(6, '江苏省');

-- --------------------------------------------------------

--
-- Table structure for table `public_license`
--

CREATE TABLE `public_license` (
  `ID` int(11) NOT NULL COMMENT '编号',
  `DOC_CODE` varchar(50) NOT NULL COMMENT '行政许可决定书文号',
  `PROJECT_NAME` varchar(50) NOT NULL COMMENT '项目名称',
  `LICENSE_CODE` varchar(50) NOT NULL COMMENT '行政许可编码',
  `APPROVAL_CONTENT` varchar(50) NOT NULL COMMENT '审批类别',
  `PERMIT_CONTENT` blob NOT NULL COMMENT '许可内容',
  `PUBLISH_OBJECT_NAME` varchar(50) NOT NULL COMMENT '行政相对人名称',
  `CREDIT_CODE` varchar(50) NOT NULL COMMENT '行政相对人代码_1 (统一社会信用代码)',
  `ORGANIZATION_CODE` varchar(50) NOT NULL COMMENT '行政相对人代码_2 (组织机构代码)',
  `BUSINESS_REGISTER_CODE` varchar(50) NOT NULL COMMENT '行政相对人代码_3 (工商登记码)',
  `TAX_REGISTER_CODE` varchar(50) NOT NULL COMMENT '行政相对人代码_4 (税务登记号)',
  `ID_CODE` varchar(50) NOT NULL COMMENT '行政相对人代码_5 (居民身份证号)',
  `LEGAL_NAME` varchar(50) NOT NULL COMMENT '法定代表人姓名',
  `PUNISH_RESULT` blob NOT NULL COMMENT '处罚结果',
  `PUNISH_DATE` date NOT NULL COMMENT '处罚决定日期',
  `PUNISH_UNIT` varchar(50) NOT NULL COMMENT '处罚机关',
  `STATUS` varchar(20) NOT NULL COMMENT '当前状态',
  `ADDRESS_CODE` varchar(50) NOT NULL COMMENT '地方编码',
  `UPDATE_DATE` varchar(50) NOT NULL COMMENT '数据更新时间戳',
  `REMARKS` blob NOT NULL COMMENT '备注',
  `INFORMATION_SCOPE` varchar(50) NOT NULL COMMENT '信息使用范围',
  `LOSE_CREDIT_GRADE` varchar(50) NOT NULL COMMENT '失信严重程度',
  `PUBLIC_EXPIRE_DATE` date NOT NULL COMMENT '公示截止日期',
  `CREATER` varchar(50) NOT NULL COMMENT '创建人',
  `CREATETIME` date NOT NULL COMMENT '创建时间',
  `UPDATER` varchar(50) NOT NULL COMMENT '更新人',
  `UPDATETIME` date NOT NULL COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `public_license`
--

INSERT INTO `public_license` (`ID`, `DOC_CODE`, `PROJECT_NAME`, `LICENSE_CODE`, `APPROVAL_CONTENT`, `PERMIT_CONTENT`, `PUBLISH_OBJECT_NAME`, `CREDIT_CODE`, `ORGANIZATION_CODE`, `BUSINESS_REGISTER_CODE`, `TAX_REGISTER_CODE`, `ID_CODE`, `LEGAL_NAME`, `PUNISH_RESULT`, `PUNISH_DATE`, `PUNISH_UNIT`, `STATUS`, `ADDRESS_CODE`, `UPDATE_DATE`, `REMARKS`, `INFORMATION_SCOPE`, `LOSE_CREDIT_GRADE`, `PUBLIC_EXPIRE_DATE`, `CREATER`, `CREATETIME`, `UPDATER`, `UPDATETIME`) VALUES
(0, 'CODE1', '项目名称	', 'CODE1', '审批类别	', '', '行政相对人名称	', 'CODE1', 'CODE1', 'CODE1', 'CODE1', 'CODE1', '法定代表人姓名	', '', '2019-09-27', '处罚机关	', '当前状态	', '地方编码	', '', '', '信息使用范围	', '失信严重程度	', '2019-09-27', '创建人	', '2019-09-27', '创建人	', '2019-09-27');

-- --------------------------------------------------------

--
-- Table structure for table `public_punish`
--

CREATE TABLE `public_punish` (
  `ID` int(11) NOT NULL COMMENT '编号',
  `DOC_CODE` varchar(50) NOT NULL COMMENT '行政处罚决定书文号',
  `PUNISH_NAME` varchar(50) NOT NULL COMMENT '处罚名称',
  `PUNISH_TYPE_F` varchar(50) NOT NULL COMMENT '处罚类别1',
  `PUNISH_TYPE_S` varchar(50) NOT NULL COMMENT '处罚类别2',
  `PUNISH_REASON` blob NOT NULL COMMENT '处罚事由',
  `PUNISH_FOUNDATION` blob NOT NULL COMMENT '处罚依据',
  `PUNISH_OBJECT_NAME` varchar(50) NOT NULL COMMENT '行政相对人名称',
  `CREDIT_CODE` varchar(50) NOT NULL COMMENT '行政相对人代码_1 (统一社会信用代码)',
  `ORGANIZATION_CODE` varchar(50) NOT NULL COMMENT '行政相对人代码_2 (组织机构代码)',
  `BUSINESS_REGISTER_CODE` varchar(50) NOT NULL COMMENT '行政相对人代码_3 (工商登记码)',
  `TAX_REGISTER_CODE` varchar(50) NOT NULL COMMENT '行政相对人代码_4 (税务登记号)',
  `ID_CODE` varchar(50) NOT NULL COMMENT '行政相对人代码_5 (居民身份证号)',
  `LEGAL_NAME` varchar(50) NOT NULL COMMENT '法定代表人姓名',
  `PUNISH_RESULT` blob NOT NULL COMMENT '处罚结果',
  `PUNISH_DATE` date NOT NULL COMMENT '处罚决定日期',
  `PUNISH_UNIT` varchar(50) NOT NULL COMMENT '处罚机关',
  `STATUS` varchar(20) NOT NULL COMMENT '当前状态',
  `ADDRESS_CODE` varchar(50) NOT NULL COMMENT '地方编码',
  `UPDATE_DATE` varchar(50) NOT NULL COMMENT '数据更新时间戳',
  `REMARKS` blob NOT NULL COMMENT '备注',
  `INFORMATION_SCOPE` varchar(50) NOT NULL COMMENT '信息使用范围',
  `LOSE_CREDIT_GRADE` varchar(50) NOT NULL COMMENT '失信严重程度',
  `PUBLIC_EXPIRE_DATE` date NOT NULL COMMENT '公示截止日期',
  `CREATER` varchar(50) NOT NULL COMMENT '创建人',
  `CREATETIME` date NOT NULL COMMENT '创建时间',
  `UPDATER` varchar(50) NOT NULL COMMENT '更新人',
  `UPDATETIME` date NOT NULL COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `public_punish`
--

INSERT INTO `public_punish` (`ID`, `DOC_CODE`, `PUNISH_NAME`, `PUNISH_TYPE_F`, `PUNISH_TYPE_S`, `PUNISH_REASON`, `PUNISH_FOUNDATION`, `PUNISH_OBJECT_NAME`, `CREDIT_CODE`, `ORGANIZATION_CODE`, `BUSINESS_REGISTER_CODE`, `TAX_REGISTER_CODE`, `ID_CODE`, `LEGAL_NAME`, `PUNISH_RESULT`, `PUNISH_DATE`, `PUNISH_UNIT`, `STATUS`, `ADDRESS_CODE`, `UPDATE_DATE`, `REMARKS`, `INFORMATION_SCOPE`, `LOSE_CREDIT_GRADE`, `PUBLIC_EXPIRE_DATE`, `CREATER`, `CREATETIME`, `UPDATER`, `UPDATETIME`) VALUES
(0, '行政许可决定书文号	', '项目名称	', '行政许可编码	', '审批类别	', '', '', '行政相对人名称	', 'CODE1', 'CODE1', 'CODE1', 'CODE1', 'CODE1', '法定代表人姓名	', '', '2019-09-27', '处罚机关	', '当前状态	', '地方编码	', '0000-00-00 00:00:00', '', '信息使用范围	', '失信严重程度	', '2019-09-27', '创建人	', '2019-09-27', '创建人	', '2019-09-27');

-- --------------------------------------------------------

--
-- Table structure for table `quality_standard`
--

CREATE TABLE `quality_standard` (
  `QUALITY_STANDARD_ID` int(11) NOT NULL COMMENT '三品一标主键',
  `CREDIT_CODE` varchar(50) NOT NULL COMMENT '行政相对人代码_1 (统一社会信用代码)',
  `CERTIFICATION_TYPE` varchar(50) NOT NULL COMMENT '认证类型（1：无公害产品，2：绿色食品，3：有机食品，4：地理标志）',
  `PRODUCT_ID` int(11) NOT NULL COMMENT '产品ID : product_production',
  `CERTIFICATION_CATEGORY` varchar(50) DEFAULT NULL COMMENT '认证类别(1:)',
  `AGRICULTURAL_CLASSIFICATION` varchar(50) DEFAULT NULL COMMENT '农业分类(1:养殖业，2：畜牧业，3：种植业)',
  `CERTIFICATION_START_TIME` datetime DEFAULT NULL COMMENT '认证开始时间',
  `CERTIFICATION_END_TIME` datetime DEFAULT NULL COMMENT '认证到期时间',
  `OUTPUT` varchar(50) DEFAULT NULL COMMENT '产量',
  `FILES` varchar(500) DEFAULT NULL COMMENT '附件',
  `CREATEDATE` datetime NOT NULL COMMENT '创建时间',
  `CREATER` varchar(50) NOT NULL COMMENT '创建人',
  `UPDATER` varchar(50) NOT NULL COMMENT '更新人',
  `UPDATEDATE` datetime NOT NULL COMMENT '更新时间',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='三品一标' ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `quality_standard`
--

INSERT INTO `quality_standard` (`QUALITY_STANDARD_ID`, `CREDIT_CODE`, `CERTIFICATION_TYPE`, `PRODUCT_ID`, `CERTIFICATION_CATEGORY`, `AGRICULTURAL_CLASSIFICATION`, `CERTIFICATION_START_TIME`, `CERTIFICATION_END_TIME`, `OUTPUT`, `FILES`, `CREATEDATE`, `CREATER`, `UPDATER`, `UPDATEDATE`, `CREATE_TIME`, `CREATE_USER_ID`, `UPDATE_TIME`, `UPDATE_USER_ID`) VALUES
(1, 'CODE1', '1', 1, '认证类别', '1', '2019-09-27 02:07:55', '2019-09-27 02:07:55', '产量', NULL, '2019-09-27 02:07:55', '章宇', '章宇', '2019-09-27 02:07:55', '2019-09-27 02:07:55', 1, '2019-09-27 02:07:55', 1),
(2, 'CODE1', '1', 1, '认证类别', '1', '2019-09-27 02:08:45', '2019-09-27 02:08:45', '产量', NULL, '2019-09-27 02:08:45', '章宇', '章宇', '2019-09-27 02:08:45', '2019-09-27 02:08:45', 1, '2019-09-27 02:08:45', 1),
(3, 'CODE1', '2', 1, '认证类别', '1', '2019-09-27 02:08:45', '2019-09-27 02:08:45', '产量', NULL, '2019-09-27 02:08:45', '章宇', '章宇', '2019-09-27 02:08:45', '2019-09-27 02:08:45', 1, '2019-09-27 02:08:45', 1),
(4, 'CODE1', '1', 1, '认证类别', '2', '2019-09-27 02:08:45', '2019-09-27 02:08:45', '产量', NULL, '2019-09-27 02:08:45', '章宇', '章宇', '2019-09-27 02:08:45', '2019-09-27 02:08:45', 1, '2019-09-27 02:08:45', 1),
(5, 'CODE1', '3', 1, '认证类别', '1', '2019-09-27 02:08:45', '2019-09-27 02:08:45', '产量', NULL, '2019-09-27 02:08:45', '章宇', '章宇', '2019-09-27 02:08:45', '2019-09-27 02:08:45', 1, '2019-09-27 02:08:45', 1);

-- --------------------------------------------------------

--
-- Table structure for table `rectification_record`
--

CREATE TABLE `rectification_record` (
  `RECTIFICATION_RECORD_ID` int(11) NOT NULL COMMENT '整改记录ID',
  `TOWN_ID` int(11) DEFAULT NULL COMMENT '乡镇ID : town',
  `COMPANY_ID` int(11) DEFAULT NULL COMMENT '企业ID : company_production',
  `RECTIFICATION_RECORD_TIME` datetime DEFAULT NULL COMMENT '整改记录时间',
  `INSPECTOR` varchar(50) DEFAULT NULL COMMENT '检查人',
  `CONCLUSION` varchar(255) DEFAULT NULL COMMENT '结论（0:不合格,1:合格）',
  `CONCLUSION_FALSE_INFO` varchar(512) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '不合格检查 : {order:xxx, suggestion:xxx, others:xxx}	',
  `SCENE_PHOTOS` varchar(255) DEFAULT NULL COMMENT '现场照片',
  `SUPERVISION_SIGN` varchar(255) DEFAULT NULL COMMENT '监管人签名',
  `CONFIRMOR_SIGN` varchar(255) DEFAULT NULL COMMENT '确认人签名',
  `SUPERVISION_RECORD_ID` int(11) NOT NULL COMMENT '监管记录ID : supervision_record',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='整改记录' ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `sample_check`
--

CREATE TABLE `sample_check` (
  `SAMPLE_CHECK_ID` int(11) NOT NULL COMMENT '例行抽查ID',
  `SAMPLE_ID` int(11) NOT NULL DEFAULT '0' COMMENT '样品ID',
  `SAMPLE_NAME` varchar(50) NOT NULL DEFAULT '0' COMMENT '样品名称',
  `SAMPLE_TIME` datetime NOT NULL COMMENT '检测时间',
  `CHECK_PERSON` varchar(50) NOT NULL COMMENT '检测人员',
  `CHECK_FILES` varchar(500) NOT NULL COMMENT '抽查附件',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='例行抽查' ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `seed`
--

CREATE TABLE `seed` (
  `SEED_ID` int(11) NOT NULL COMMENT '种子ID',
  `SEED_PROFILES` varchar(1000) DEFAULT NULL COMMENT '种子附件',
  `VILLAGE_ID` int(11) DEFAULT NULL COMMENT '村ID',
  `TOWN_ID` int(11) DEFAULT NULL COMMENT '乡镇ID',
  `CITY_ID` int(11) DEFAULT NULL COMMENT '市ID',
  `COMPANY_ID` int(11) DEFAULT NULL COMMENT '企业ID',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='种子' ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `supervision_record`
--

CREATE TABLE `supervision_record` (
  `SUPERVISION_RECORD_ID` int(11) NOT NULL COMMENT '监管记录ID',
  `PRODUCTION_SUBJECT_TYPE` varchar(50) DEFAULT NULL COMMENT '生产主体类型(1:企业 2：农户)',
  `TOWN_ID` int(11) DEFAULT NULL COMMENT '乡镇ID : town',
  `COMPANY_ID` int(11) DEFAULT NULL COMMENT '企业ID : company_production',
  `SUPERVISION_RECORD_TIME` datetime DEFAULT NULL COMMENT '监管记录时间',
  `INSPECTOR` varchar(50) DEFAULT NULL COMMENT '检查人',
  `USEFUL_EXPRESSIONS` varchar(255) DEFAULT NULL COMMENT '常用语',
  `OTHER_PROBLEMS` varchar(255) DEFAULT NULL COMMENT '现场发现的其他问题',
  `CONCLUSION` varchar(255) DEFAULT NULL COMMENT '结论（0:不合格,1:合格）',
  `CONCLUSION_FALSE_INFO` varchar(512) NOT NULL COMMENT '不合格检查 : {order:xxx, suggestion:xxx, others:xxx}',
  `SCENE_PHOTOS` varchar(500) DEFAULT NULL COMMENT '现场照片',
  `SIGN` varchar(500) DEFAULT NULL COMMENT '签名',
  `SUPERVISION_INFO` varchar(2000) DEFAULT NULL COMMENT '检查内容与结果 : {production:1, input:1, abuse:1, origin:1, inspection:1, standard:1}',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='监管记录' ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `town`
--

CREATE TABLE `town` (
  `ID` bigint(20) NOT NULL,
  `DIVISION_CODE` bigint(20) NOT NULL,
  `NAME` varchar(40) DEFAULT NULL,
  `SUPERVISE_SYSTEM` varchar(2000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `town`
--

INSERT INTO `town` (`ID`, `DIVISION_CODE`, `NAME`, `SUPERVISE_SYSTEM`) VALUES
(1, 320581101000, '梅李镇', '{"level1":[{"title":"分管农业副镇长","name":"浦方勇","$$hashKey":"006"}],"level2leader":{"name":"鞠庆华"},"level2":[{"title":"科长","name":"陈国庆","$$hashKey":"007"},{"title":"科员","name":"管霜怡","$$hashKey":"008"}],"level3":[{"title":"快检员","name":"吴剑","$$hashKey":"009"}],"level4":[{"title":"胜法村协管员","name":"赵健"},{"title":"聚沙村协管员","name":"包鸣裕"},{"title":"天字村协管员","name":"陆剑"},{"title":"梅南村协管员","name":"杨爱忠"},{"title":"塘桥村协管员","name":"张振军"},{"title":"寨角村协管员","name":"谢国良"},{"title":"瞿巷村协管员","name":"陈学明"},{"title":"赵市村协管员","name":"赵益飞"},{"title":"海城村协管员","name":"徐晓峰"},{"title":"师桥村协管员","name":"钱晓峰"},{"title":"圩港村协管员","name":"龚文明"},{"title":"珍北村协管员","name":"殷晓磊"},{"title":"珍南村协管员","name":"唐丽峰"},{"title":"新丰村协管员","name":"潘雷"},{"title":"沈市村协管员","name":"毛晓丰"}]}'),
(2, 320581102000, '海虞镇', '{"level1":[{"title":"党委委员","name":"吴江"},{"title":"协理员","name":"陈永华"}],"level2leader":{"name":"邵慧霞"},"level2":[],"level3":[{"title":"监管站","name":"穆晓伟","$$hashKey":"009"},{"title":"监管站","name":"贺飞","$$hashKey":"00A"}],"level4":[{"title":"里泾村","name":"季国金","$$hashKey":"0A1"},{"title":"汪桥村","name":"蔡海军","$$hashKey":"0A2"},{"title":"香桥村","name":"陈晖","$$hashKey":"0A3"},{"title":"虞南村","name":"屈俊","$$hashKey":"0A4"},{"title":"新州村","name":"徐凯","$$hashKey":"0A5"},{"title":"河口村","name":"王云祥","$$hashKey":"0A6"},{"title":"府东村","name":"温永华","$$hashKey":"0A7"},{"title":"东泾村","name":"施俊","$$hashKey":"0A8"},{"title":"龙墩村","name":"潘缪球","$$hashKey":"0A9"},{"title":"望虞村","name":"金军","$$hashKey":"0AA"},{"title":"徐桥村","name":"赵斌","$$hashKey":"0AB"},{"title":"肖桥村","name":"袁叶飞","$$hashKey":"0AC"},{"title":"邓市村","name":"支国球","$$hashKey":"0AD"},{"title":"聚福村","name":"邹春健","$$hashKey":"0AE"},{"title":"福山村","name":"李国东","$$hashKey":"0AF"},{"title":"七峰村","name":"周冬","$$hashKey":"0AG"},{"title":"福山农场","name":"刘昌","$$hashKey":"0AH"},{"title":"郑家桥村","name":"金盛","$$hashKey":"0AI"}]}'),
(3, 320581104000, '古里镇', '{"level1":[{"title":"分管副镇长","name":"万拥东","$$hashKey":"006"}],"level2leader":{"name":"王冬明"},"level2":[],"level3":[{"title":"农产品质量安全监管站","name":"顾雪刚"},{"title":"农产品质量安全监管站","name":"庄黎萍"},{"title":"农产品质量安全监管站","name":"刘益"}],"level4":[{"title":"紫芙社区","name":"夏伟","$$hashKey":"08W"},{"title":"康博村","name":"高晓春","$$hashKey":"08X"},{"title":"紫霞村","name":"严建锋","$$hashKey":"08Y"},{"title":"芙蓉村","name":"陈子昂","$$hashKey":"08Z"},{"title":"坞坵村","name":"杨潇","$$hashKey":"090"},{"title":"联泾村","name":"唐士良","$$hashKey":"091"},{"title":"李市村","name":"高飞","$$hashKey":"092"},{"title":"琴东村","name":"冯叶庭","$$hashKey":"093"},{"title":"新桥村","name":"李金健","$$hashKey":"094"},{"title":"苏家尖村","name":"陈弃疾","$$hashKey":"095"},{"title":"高长村","name":"陆金元","$$hashKey":"096"},{"title":"双港村","name":"袁熙明","$$hashKey":"097"},{"title":"吴庄村","name":"陶志忠","$$hashKey":"098"},{"title":"陈塘村","name":"王永新","$$hashKey":"099"},{"title":"下甲村","name":"王卫兵","$$hashKey":"09A"},{"title":"淼泉居委","name":"顾文辉","$$hashKey":"09B"}]}'),
(4, 320581105000, '沙家浜镇', '{"level1":[{"title":"分管副镇长","name":"支月明","$$hashKey":"006"}],"level2leader":{"name":"龚学兴"},"level2":[],"level3":[{"title":"沙家浜镇农产品质量安全监管服务站","name":"杜梦雅","$$hashKey":"0DN"},{"title":"沙家浜镇农产品质量安全监管服务站","name":"朱孝斌","$$hashKey":"0DO"}],"level4":[{"title":"常昆村","name":"刘毅磊","$$hashKey":"077"},{"title":"红石村","name":"夏健","$$hashKey":"078"},{"title":"苏南村","name":"朱洪峰","$$hashKey":"079"},{"title":"昆承湖村","name":"陈忠","$$hashKey":"07A"},{"title":"沙南村","name":"苏建新","$$hashKey":"07B"},{"title":"唐北村","name":"毛晓程","$$hashKey":"07C"},{"title":"朗城村","name":"张兴保","$$hashKey":"07D"},{"title":"芦荡社区","name":"林杰","$$hashKey":"07E"},{"title":"华阳村","name":"许子杰","$$hashKey":"07F"},{"title":"横泾村","name":"何晓佳","$$hashKey":"07G"},{"title":"唐东村","name":"闵勇","$$hashKey":"07H"},{"title":"新湖村","name":"杨树佳","$$hashKey":"07I"},{"title":"芦荡村","name":"顾春江","$$hashKey":"07J"},{"title":"昆南村","name":"王江","$$hashKey":"07K"},{"title":"","name":"","$$hashKey":"07L"}]}'),
(5, 320581106000, '支塘镇', '{"level1":[{"title":"分管副镇长","name":"朱文勇","$$hashKey":"006"}],"level2leader":{"name":"朱雪明"},"level2":[],"level3":[{"title":"农产品质量安全监管站","name":"严伟才","$$hashKey":"007"},{"title":"农产品质量安全监管站","name":"徐福明","$$hashKey":"008"}],"level4":[{"title":"丰联村","name":"周亚"},{"title":"蒋巷村","name":"王进明"},{"title":"任南村","name":"顾向军"},{"title":"徐政村","name":"浦锦峰"},{"title":"凤泾村","name":"徐宝国"},{"title":"盛泾村","name":"郭佳"},{"title":"窑镇村","name":"李钢"},{"title":"八字桥村","name":"李勤"},{"title":"枫塘村","name":"张健"},{"title":"阳桥村","name":"陆晓军"},{"title":"项桥村","name":"张晓斌"},{"title":"支东村","name":"苏正红"},{"title":"长桥村","name":"袁建龙"},{"title":"何东村","name":"周春健"},{"title":"何南村","name":"江平"},{"title":"何北村","name":"戴建峰"}]}'),
(6, 320581107000, '董浜镇', '{"level1":[{"title":"分管副镇长","name":"王志丰","$$hashKey":"03P"}],"level2leader":{"name":"杜建军"},"level2":[{"title":"农机、水产、粮食","name":"顾建宏","$$hashKey":"03P"},{"title":"蔬菜","name":"刘斌","$$hashKey":"03Q"}],"level3":"","level4":[{"title":"北港村","name":"李展"},{"title":"里睦村","name":"陆晓益"},{"title":"东盾村","name":"祁敏纶"},{"title":"黄石村","name":"钱志成"},{"title":"智林村","name":"皇甫梦涛"},{"title":"陆市村","name":"徐洁"},{"title":"杨塘村","name":"何建华"},{"title":"旗杆村","name":"杨晓佳"},{"title":"天星村","name":"沈健"},{"title":"新民村","name":"冯剑"},{"title":"永安村","name":"顾星"},{"title":"杜桥村","name":"姚正冬"},{"title":"红沙村","name":"马旭平"},{"title":"观智村","name":"顾乾"}]}'),
(7, 320581110000, '辛庄镇', NULL),
(8, 320581111000, '尚湖镇', '{"level1":[{"title":"分管副镇长","name":"金国清","$$hashKey":"006"}],"level2leader":{"name":"谈中英"},"level2":[{"title":"","name":""}],"level3":[{"title":"农产品质量安全监管站","name":"李小妹","$$hashKey":"008"},{"title":"农产品质量安全监管站","name":"苗冰花","$$hashKey":"009"}],"level4":[{"title":"福寿村","name":"杨晓春","$$hashKey":"05Q"},{"title":"河金村","name":"徐海兵","$$hashKey":"05R"},{"title":"东桥村","name":"李春","$$hashKey":"05S"},{"title":"家鑫村","name":"周吴","$$hashKey":"05T"},{"title":"车路坝村","name":"朱卫东","$$hashKey":"05U"},{"title":"山鑫村","name":"王科","$$hashKey":"05V"},{"title":"张村村","name":"马晓东","$$hashKey":"05W"},{"title":"南村坝村","name":"施丁峰","$$hashKey":"05X"},{"title":"颜巷村","name":"唐利民","$$hashKey":"05Y"},{"title":"鸳鸯桥村","name":"朱龙保","$$hashKey":"05Z"},{"title":"常兴村","name":"王建平","$$hashKey":"060"},{"title":"练南村","name":"王文清","$$hashKey":"061"},{"title":"吉桥村","name":"陆建新","$$hashKey":"062"},{"title":"罗墩村","name":"戴清","$$hashKey":"063"},{"title":"翁家庄村","name":"周丹","$$hashKey":"064"},{"title":"大河村","name":"吴晓丰","$$hashKey":"065"},{"title":"新裕村","name":"杨建军","$$hashKey":"066"},{"title":"新巷村","name":"陶胜","$$hashKey":"067"},{"title":"新鑫村","name":"须国清","$$hashKey":"068"},{"title":"蒋巷镇村","name":"薛忠","$$hashKey":"069"},{"title":"湖庄村","name":"周红星","$$hashKey":"06A"},{"title":"新和村","name":"秦卫","$$hashKey":"06B"}]}'),
(9, 320581400000, '虞山林场', '{"level1":[{"title":"分管领导","name":"范仲华","$$hashKey":"006"}],"level2leader":{"name":"吴瑞石"},"level2":[],"level3":[{"title":"监管员","name":"柴珂心","$$hashKey":"007"}],"level4":[{"title":"甸桥村","name":"俞忠良"},{"title":"建华村","name":"管飞"},{"title":"元和村","name":"肖峰"},{"title":"宝岩村","name":"陈军"},{"title":"大湖甸村","name":"钱卫星"},{"title":"洩水村","name":"朱益新"},{"title":"尚湖社区","name":"钱勇"},{"title":"兴福管理区","name":"王驰"},{"title":"三峰管理区","name":"邓建忠"},{"title":"宝岩管理区","name":"宗怡"}]}'),
(14, 320581405000, '碧溪街道办事处', '{"level1":[{"title":"","name":"夏健","$$hashKey":"006"}],"level2leader":{"name":"陆燕"},"level2":[],"level3":[{"title":"监管站","name":"缪进"},{"title":"监管站","name":"夏维芳"},{"title":"监管站","name":"周佳"},{"title":"监管站","name":"郁娅池"}],"level4":[{"title":"溪东村","name":"王健","$$hashKey":"073"},{"title":"溪南村","name":"包卫东","$$hashKey":"074"},{"title":"港南村","name":"朱志明","$$hashKey":"075"},{"title":"周泾村","name":"沈建昌","$$hashKey":"076"},{"title":"李村村","name":"王建飞","$$hashKey":"077"},{"title":"徐虎村","name":"陶新异","$$hashKey":"078"},{"title":"浒西村","name":"徐晓东","$$hashKey":"079"},{"title":"李袁村","name":"穆明杰","$$hashKey":"07A"},{"title":"留下村","name":"包健","$$hashKey":"07B"},{"title":"三湾村","name":"李健峰","$$hashKey":"07C"},{"title":"太平桥村","name":"曹重龙","$$hashKey":"07D"},{"title":"周家桥村","name":"曹惠峰","$$hashKey":"07E"},{"title":"横塘村","name":"尹建新","$$hashKey":"07F"},{"title":"龙桥村","name":"刘凯","$$hashKey":"07G"},{"title":"新苑村","name":"王卫国","$$hashKey":"07H"},{"title":"中南村","name":"陆海军","$$hashKey":"07I"},{"title":"白莲村","name":"黄驰","$$hashKey":"07J"},{"title":"万福村","name":"夏峻凯","$$hashKey":"07K"}]}'),
(15, 320581003000, '琴川街道', '{"level1":[{"title":"街道党工委委员","name":"马卫明","$$hashKey":"0IC"}],"level2leader":{"name":""},"level2":[{"title":"分管","name":"胡金祥"}],"level3":[{"title":"监管站","name":"胡金祥","$$hashKey":"0I2"}],"level4":[{"title":"大虹桥","name":"杨佳斌","$$hashKey":"09K"},{"title":"东环","name":"徐佳正","$$hashKey":"09L"},{"title":"景龙","name":"朱新","$$hashKey":"09M"},{"title":"浦浜","name":"浦生保","$$hashKey":"09N"}]}'),
(16, 320581004000, '莫城街道', '{"level1":[{"title":"莫城街道政协工委主任","name":"张建明","$$hashKey":"006"},{"title":"莫城街道党工委副主任","name":"须文胜","$$hashKey":"007"}],"level2leader":{"name":"陆建洪"},"level2":[],"level3":[{"title":"监管","name":"朱    颖"},{"title":"监管","name":"陈志豪"}],"level4":[{"title":"安定村","name":"沈雪峰","$$hashKey":"09R"},{"title":"三瑭村","name":"王建明","$$hashKey":"09S"},{"title":"湖鹤村","name":"邵    振","$$hashKey":"09T"},{"title":"长瑞村","name":"蒋苏丹","$$hashKey":"09U"},{"title":"东青村","name":"孙    峰","$$hashKey":"09V"},{"title":"三和村","name":"邱忠林","$$hashKey":"09W"},{"title":"燕巷村","name":"姚    奇","$$hashKey":"09X"},{"title":"和甸村","name":"陈明元","$$hashKey":"09Y"},{"title":"东始村","name":"缪    峰","$$hashKey":"09Z"},{"title":"三星村","name":"卞志强","$$hashKey":"0A0"}]}'),
(17, 320581002000, '常福街道', '{"level1":[{"title":"常福街道党工委委员","name":"蔡胜"}],"level2leader":{"name":"李仁清"},"level2":[],"level3":[{"title":"监管站","name":"李建青","$$hashKey":"006"},{"title":"监管站","name":"朱晓非","$$hashKey":"007"},{"title":"监管站","name":"朱辰杰","$$hashKey":"008"},{"title":"监管站","name":"陈俊驰","$$hashKey":"009"}],"level4":[{"title":"明晶村","name":"金耀青","$$hashKey":"1H2"},{"title":"永红村","name":"蔡学文","$$hashKey":"1H3"},{"title":"勤丰村","name":"叶志敏","$$hashKey":"1H4"},{"title":"方浜村","name":"屈静江","$$hashKey":"1H5"},{"title":"五新村","name":"赵国成","$$hashKey":"1H6"},{"title":"蜂蚁村","name":"王旭","$$hashKey":"1H7"},{"title":"光明村","name":"顾仁华","$$hashKey":"1H8"},{"title":"中泾村","name":"苏新","$$hashKey":"1H9"},{"title":"常隆村","name":"邹文彬","$$hashKey":"1HA"},{"title":"小义村","name":"颜惠忠","$$hashKey":"1HB"},{"title":"东联村","name":"陆慧","$$hashKey":"1HC"},{"title":"压路机村","name":"阚勇","$$hashKey":"1HD"},{"title":"小山村","name":"黄雪东","$$hashKey":"1HE"},{"title":"常福村","name":"王文瀚","$$hashKey":"1HF"},{"title":"新红村","name":"顾镇","$$hashKey":"1HG"},{"title":"福圩村","name":"陈志忠","$$hashKey":"1HH"},{"title":"翻身村","name":"陈健","$$hashKey":"1HI"},{"title":"毛桥村","name":"高亚萍","$$hashKey":"1HJ"},{"title":"合丰村","name":"王仁华","$$hashKey":"1HK"},{"title":"顶山村","name":"朱建中","$$hashKey":"1HL"},{"title":"联盟村","name":"赵志云","$$hashKey":"1HM"},{"title":"丁坝社区","name":"李华","$$hashKey":"1HN"},{"title":"谢桥社区","name":"凌伟良","$$hashKey":"1HO"},{"title":"大义社区","name":"周雪霞","$$hashKey":"1HP"},{"title":"新义社区","name":"顾静","$$hashKey":"1HQ"},{"title":"绿地社区","name":"朱雨斌","$$hashKey":"1HR"},{"title":"怡馨社区","name":"蒋丽英","$$hashKey":"1HS"},{"title":"游文社区","name":"蒋少兰","$$hashKey":"1HT"},{"title":"景泰社区","name":"金小妹","$$hashKey":"1HU"},{"title":"珠海社区","name":"顾晓燕","$$hashKey":"1HV"},{"title":"碧海社区","name":"张轶","$$hashKey":"1HW"}]}'),
(18, 320581100000, '虞山镇', '{"level1":[{"title":"222","name":"222","$$hashKey":"2GP"},{"title":"dsad","name":"dsad","$$hashKey":"2GQ"}],"level2leader":{"name":"张伟"},"level2":[],"level3":[],"level4":[]}');

-- --------------------------------------------------------

--
-- Table structure for table `training_funds`
--

CREATE TABLE `training_funds` (
  `TRAINING_FUNDS_ID` int(11) NOT NULL COMMENT '培训经费ID',
  `PROJECT_NAME` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `APPLIED_AMOUNT` decimal(10,2) DEFAULT NULL COMMENT '申请金额',
  `PROPOSER` varchar(255) DEFAULT NULL COMMENT '申请人',
  `COMPANY_ID` int(11) NOT NULL COMMENT '所在单位ID',
  `TRAINING_FUNDS_PROFILES` varchar(1000) DEFAULT NULL COMMENT '培训经费附件',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='培训经费' ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL COMMENT 'id',
  `user_id` varchar(255) DEFAULT NULL COMMENT '登录名',
  `contact_name` varchar(32) NOT NULL COMMENT '名称',
  `user_type` int(11) NOT NULL COMMENT '角色 (1:市级管理员, 2:乡镇管理员, 3: 普通用户)',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `contact_person` varchar(32) NOT NULL COMMENT '联系人',
  `contact_way` varchar(32) NOT NULL COMMENT '联系方式',
  `credit_code` varchar(64) NOT NULL COMMENT '统一社会信用代码',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` varchar(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` varchar(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `user_id`, `contact_name`, `user_type`, `password`, `contact_person`, `contact_way`, `credit_code`, `CREATE_TIME`, `CREATE_USER_ID`, `UPDATE_TIME`, `UPDATE_USER_ID`) VALUES
(1, '章宇', '', 0, '', '', '', '', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `village`
--

CREATE TABLE `village` (
  `ID` bigint(20) NOT NULL,
  `PROVINCE_ID` bigint(20) NOT NULL,
  `CITY_ID` bigint(20) NOT NULL,
  `COUNTY_ID` bigint(20) NOT NULL,
  `NAME` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `village`
--

INSERT INTO `village` (`ID`, `PROVINCE_ID`, `CITY_ID`, `COUNTY_ID`, `NAME`) VALUES
(0, 4, 1, 1, '常熟直属'),
(0, 6, 1, 1, '常熟市直属'),
(1, 4, 1, 1, '虞山'),
(1, 6, 1, 1, '董浜镇'),
(2, 4, 1, 1, '梅李'),
(3, 4, 1, 1, '董浜镇'),
(4, 4, 1, 1, '尚湖');

-- --------------------------------------------------------

--
-- Table structure for table `warehouse`
--

CREATE TABLE `warehouse` (
  `WAREHOUSE_ID` int(11) NOT NULL COMMENT '仓库ID',
  `WAREHOUSE_NAME` varchar(255) DEFAULT NULL COMMENT '仓库名称',
  `WAREHOUSE_ADDRESS` varchar(255) DEFAULT NULL COMMENT '仓库地址',
  `WAREHOUSE_AREA` decimal(10,2) DEFAULT NULL COMMENT '仓库面积',
  `WAREHOUSE_SCOPE` varchar(255) DEFAULT NULL COMMENT '仓库规模',
  `COMPANY_ID` int(11) NOT NULL COMMENT '生产主体ID : company_production',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='仓储环境' ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `work_task`
--

CREATE TABLE `work_task` (
  `WORK_TASK_ID` int(11) NOT NULL COMMENT '工作任务ID',
  `RELEASE_TIME` datetime DEFAULT NULL COMMENT '发布日期',
  `RELEASE_PERSON` varchar(50) DEFAULT NULL COMMENT '发布人',
  `TITLE` varchar(255) DEFAULT NULL COMMENT '标题',
  `CONTENT` varchar(500) DEFAULT NULL COMMENT '内容',
  `WORK_TASK_PROFILES` varchar(1000) DEFAULT NULL COMMENT '工作任务附件',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作任务' ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- Table structure for table `work_task_report`
--

CREATE TABLE `work_task_report` (
  `WORK_TASK_REPORT_ID` int(11) NOT NULL COMMENT '工作任务汇报ID',
  `WORK_TASK_ID` int(11) NOT NULL COMMENT '工作任务ID',
  `REPORT_TIME` datetime DEFAULT NULL COMMENT '汇报日期',
  `TOWN_ID` int(11) DEFAULT NULL COMMENT '汇报单位',
  `REPORT_PERSON` varchar(50) DEFAULT NULL COMMENT '汇报人',
  `REPORT_CONTENT` varchar(1000) DEFAULT NULL COMMENT '汇报内容',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` int(32) DEFAULT NULL COMMENT '创建人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` int(32) DEFAULT NULL COMMENT '更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作任务汇报' ROW_FORMAT=DYNAMIC;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`ID`,`PROVINCE_ID`) USING BTREE;

--
-- Indexes for table `company_business`
--
ALTER TABLE `company_business`
  ADD PRIMARY KEY (`COMPANY_ID`) USING BTREE;

--
-- Indexes for table `company_credit_grade`
--
ALTER TABLE `company_credit_grade`
  ADD PRIMARY KEY (`CREDIT_GRADE_ID`) USING BTREE;

--
-- Indexes for table `company_production`
--
ALTER TABLE `company_production`
  ADD PRIMARY KEY (`COMPANY_ID`) USING BTREE;

--
-- Indexes for table `county`
--
ALTER TABLE `county`
  ADD PRIMARY KEY (`ID`,`PROVINCE_ID`,`CITY_ID`) USING BTREE;

--
-- Indexes for table `disability_check`
--
ALTER TABLE `disability_check`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `inputs_purchase`
--
ALTER TABLE `inputs_purchase`
  ADD PRIMARY KEY (`INPUTS_ID`) USING BTREE;

--
-- Indexes for table `inputs_use`
--
ALTER TABLE `inputs_use`
  ADD PRIMARY KEY (`INPUTS_ID`) USING BTREE;

--
-- Indexes for table `notice`
--
ALTER TABLE `notice`
  ADD PRIMARY KEY (`NOTICE_ID`) USING BTREE;

--
-- Indexes for table `notice_note_record`
--
ALTER TABLE `notice_note_record`
  ADD PRIMARY KEY (`NOTE_RECORD_ID`) USING BTREE;

--
-- Indexes for table `pesticide_check`
--
ALTER TABLE `pesticide_check`
  ADD PRIMARY KEY (`CHECK_ID`) USING BTREE;

--
-- Indexes for table `production_records`
--
ALTER TABLE `production_records`
  ADD PRIMARY KEY (`PRODUCTION_RECORDS_ID`) USING BTREE;

--
-- Indexes for table `production_standard`
--
ALTER TABLE `production_standard`
  ADD PRIMARY KEY (`PRODUCTION_STANDARD_ID`) USING BTREE;

--
-- Indexes for table `product_batch`
--
ALTER TABLE `product_batch`
  ADD PRIMARY KEY (`PRODUCT_BATCH_ID`) USING BTREE;

--
-- Indexes for table `product_business`
--
ALTER TABLE `product_business`
  ADD PRIMARY KEY (`PRODUCT_ID`) USING BTREE;

--
-- Indexes for table `product_check_record`
--
ALTER TABLE `product_check_record`
  ADD PRIMARY KEY (`PRODUCT_CHECK_RECORD_ID`) USING BTREE;

--
-- Indexes for table `product_examining_report`
--
ALTER TABLE `product_examining_report`
  ADD PRIMARY KEY (`EXAMINING_REPORT_ID`) USING BTREE;

--
-- Indexes for table `product_grade`
--
ALTER TABLE `product_grade`
  ADD PRIMARY KEY (`GRADE_ID`) USING BTREE;

--
-- Indexes for table `product_production`
--
ALTER TABLE `product_production`
  ADD PRIMARY KEY (`PRODUCT_ID`) USING BTREE;

--
-- Indexes for table `product_property`
--
ALTER TABLE `product_property`
  ADD PRIMARY KEY (`PROPERTY_ID`) USING BTREE;

--
-- Indexes for table `product_repertory`
--
ALTER TABLE `product_repertory`
  ADD PRIMARY KEY (`REPERTORY_ID`) USING BTREE;

--
-- Indexes for table `product_sale`
--
ALTER TABLE `product_sale`
  ADD PRIMARY KEY (`PRODUCT_SALE_ID`) USING BTREE;

--
-- Indexes for table `product_task`
--
ALTER TABLE `product_task`
  ADD PRIMARY KEY (`TASK_ID`) USING BTREE;

--
-- Indexes for table `product_variety`
--
ALTER TABLE `product_variety`
  ADD PRIMARY KEY (`VARIETY_ID`) USING BTREE;

--
-- Indexes for table `province`
--
ALTER TABLE `province`
  ADD PRIMARY KEY (`ID`) USING BTREE;

--
-- Indexes for table `public_license`
--
ALTER TABLE `public_license`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `quality_standard`
--
ALTER TABLE `quality_standard`
  ADD PRIMARY KEY (`QUALITY_STANDARD_ID`) USING BTREE;

--
-- Indexes for table `rectification_record`
--
ALTER TABLE `rectification_record`
  ADD PRIMARY KEY (`RECTIFICATION_RECORD_ID`) USING BTREE;

--
-- Indexes for table `sample_check`
--
ALTER TABLE `sample_check`
  ADD PRIMARY KEY (`SAMPLE_CHECK_ID`) USING BTREE;

--
-- Indexes for table `seed`
--
ALTER TABLE `seed`
  ADD PRIMARY KEY (`SEED_ID`) USING BTREE;

--
-- Indexes for table `supervision_record`
--
ALTER TABLE `supervision_record`
  ADD PRIMARY KEY (`SUPERVISION_RECORD_ID`) USING BTREE;

--
-- Indexes for table `town`
--
ALTER TABLE `town`
  ADD PRIMARY KEY (`ID`) USING BTREE;

--
-- Indexes for table `training_funds`
--
ALTER TABLE `training_funds`
  ADD PRIMARY KEY (`TRAINING_FUNDS_ID`) USING BTREE;

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- Indexes for table `village`
--
ALTER TABLE `village`
  ADD PRIMARY KEY (`ID`,`PROVINCE_ID`,`CITY_ID`,`COUNTY_ID`) USING BTREE;

--
-- Indexes for table `warehouse`
--
ALTER TABLE `warehouse`
  ADD PRIMARY KEY (`WAREHOUSE_ID`) USING BTREE;

--
-- Indexes for table `work_task`
--
ALTER TABLE `work_task`
  ADD PRIMARY KEY (`WORK_TASK_ID`) USING BTREE;

--
-- Indexes for table `work_task_report`
--
ALTER TABLE `work_task_report`
  ADD PRIMARY KEY (`WORK_TASK_REPORT_ID`) USING BTREE;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `company_business`
--
ALTER TABLE `company_business`
  MODIFY `COMPANY_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '经营主体ID';
--
-- AUTO_INCREMENT for table `company_credit_grade`
--
ALTER TABLE `company_credit_grade`
  MODIFY `CREDIT_GRADE_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '企业信用评级ID', AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `company_production`
--
ALTER TABLE `company_production`
  MODIFY `COMPANY_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '生产主体ID', AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `disability_check`
--
ALTER TABLE `disability_check`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '农残检测ID', AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `inputs_purchase`
--
ALTER TABLE `inputs_purchase`
  MODIFY `INPUTS_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '投入品ID';
--
-- AUTO_INCREMENT for table `inputs_use`
--
ALTER TABLE `inputs_use`
  MODIFY `INPUTS_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '投入品ID';
--
-- AUTO_INCREMENT for table `notice`
--
ALTER TABLE `notice`
  MODIFY `NOTICE_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '公告ID';
--
-- AUTO_INCREMENT for table `notice_note_record`
--
ALTER TABLE `notice_note_record`
  MODIFY `NOTE_RECORD_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '短信记录ID';
--
-- AUTO_INCREMENT for table `pesticide_check`
--
ALTER TABLE `pesticide_check`
  MODIFY `CHECK_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '农残检测ID';
--
-- AUTO_INCREMENT for table `production_records`
--
ALTER TABLE `production_records`
  MODIFY `PRODUCTION_RECORDS_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '生产记录ID';
--
-- AUTO_INCREMENT for table `production_standard`
--
ALTER TABLE `production_standard`
  MODIFY `PRODUCTION_STANDARD_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '生产标准ID';
--
-- AUTO_INCREMENT for table `product_batch`
--
ALTER TABLE `product_batch`
  MODIFY `PRODUCT_BATCH_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品批次ID';
--
-- AUTO_INCREMENT for table `product_business`
--
ALTER TABLE `product_business`
  MODIFY `PRODUCT_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品ID';
--
-- AUTO_INCREMENT for table `product_check_record`
--
ALTER TABLE `product_check_record`
  MODIFY `PRODUCT_CHECK_RECORD_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '第三方抽检记录ID';
--
-- AUTO_INCREMENT for table `product_examining_report`
--
ALTER TABLE `product_examining_report`
  MODIFY `EXAMINING_REPORT_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '检测报告ID';
--
-- AUTO_INCREMENT for table `product_grade`
--
ALTER TABLE `product_grade`
  MODIFY `GRADE_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '等级ID';
--
-- AUTO_INCREMENT for table `product_production`
--
ALTER TABLE `product_production`
  MODIFY `PRODUCT_ID` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '产品ID', AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `product_property`
--
ALTER TABLE `product_property`
  MODIFY `PROPERTY_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '属性ID';
--
-- AUTO_INCREMENT for table `product_repertory`
--
ALTER TABLE `product_repertory`
  MODIFY `REPERTORY_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '库存动态ID';
--
-- AUTO_INCREMENT for table `product_sale`
--
ALTER TABLE `product_sale`
  MODIFY `PRODUCT_SALE_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '销售ID';
--
-- AUTO_INCREMENT for table `product_task`
--
ALTER TABLE `product_task`
  MODIFY `TASK_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '作业ID';
--
-- AUTO_INCREMENT for table `product_variety`
--
ALTER TABLE `product_variety`
  MODIFY `VARIETY_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '品种ID';
--
-- AUTO_INCREMENT for table `province`
--
ALTER TABLE `province`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `quality_standard`
--
ALTER TABLE `quality_standard`
  MODIFY `QUALITY_STANDARD_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '三品一标主键', AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `sample_check`
--
ALTER TABLE `sample_check`
  MODIFY `SAMPLE_CHECK_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '例行抽查ID';
--
-- AUTO_INCREMENT for table `seed`
--
ALTER TABLE `seed`
  MODIFY `SEED_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '种子ID';
--
-- AUTO_INCREMENT for table `supervision_record`
--
ALTER TABLE `supervision_record`
  MODIFY `SUPERVISION_RECORD_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '监管记录ID';
--
-- AUTO_INCREMENT for table `town`
--
ALTER TABLE `town`
  MODIFY `ID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `training_funds`
--
ALTER TABLE `training_funds`
  MODIFY `TRAINING_FUNDS_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '培训经费ID';
--
-- AUTO_INCREMENT for table `warehouse`
--
ALTER TABLE `warehouse`
  MODIFY `WAREHOUSE_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '仓库ID';
--
-- AUTO_INCREMENT for table `work_task`
--
ALTER TABLE `work_task`
  MODIFY `WORK_TASK_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '工作任务ID';
--
-- AUTO_INCREMENT for table `work_task_report`
--
ALTER TABLE `work_task_report`
  MODIFY `WORK_TASK_REPORT_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '工作任务汇报ID';
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
