/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.7.33 : Database - db_note
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_note` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_note`;

/*Table structure for table `db_admin` */

DROP TABLE IF EXISTS `db_admin`;

CREATE TABLE `db_admin` (
  `accout` varchar(32) DEFAULT '123456',
  `password` varchar(32) DEFAULT '123456'
) ENGINE=InnoDB DEFAULT CHARSET=armscii8;

/*Data for the table `db_admin` */

insert  into `db_admin`(`accout`,`password`) values ('123456','123456');

/*Table structure for table `db_user` */

DROP TABLE IF EXISTS `db_user`;

CREATE TABLE `db_user` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `accout` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `petname` varchar(32) DEFAULT NULL,
  `notenumber` int(5) DEFAULT '1',
  `isopen` tinyint(1) DEFAULT '0',
  `notetitle` varchar(32) DEFAULT NULL,
  `note` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

/*Data for the table `db_user` */

insert  into `db_user`(`id`,`accout`,`password`,`petname`,`notenumber`,`isopen`,`notetitle`,`note`) values (1,'0429','0429','小花花',1,0,'星期一','作为一个优秀的项目经理或项目带头人，必须养成良好优秀的项目命名规则和习惯。接下来把查到的资料整理一下，实际上，在很多项目中，也是遵循以下的规则。\n一、项目名\n\n全部小写，比如cms、workdesk,jobserver等\n\n二、java相关命名\na、类命名：每音节单词前的第一个字母大写，比如FieldInfo、Expression等\\\nb、普通变量(包括spring里的变量引用命名)：第一个单词前小写，以后每个单词第一个字母大写，password,primaryFlag\nc、静态变量：全部大写，多个单词则以_分开，比如BOOLEAN_FLAG\nd、包package命名：全部小写,比如com.joinspider.workdesk\n\n补充：\na、类名、变量名是名字组合，多名词顺序和中文顺序一样，比如ScriptEngine\nb、属性也可以是形容词+名词\nc、常量可使用上述规则，如果为了体现多个常量是一组的概念，也可以被修饰前置，\n比如：VAR_START，VAR_END.\nc、方法是动词+名字或者只有动词\n\n三、属性文件.properties定义变量命名\nobject.a_b_c格式，全部小写，其中object是宿主，a_b_c多个单词下划线分开。\n例：hibernate.cache.use_second_level_cache，hibernate.cache.provider_class，hibernate.cache.provider_configuration_file_resource_path\n\n四、xml文件命名\n全部小写，-符号是其xml的用途说明，类似applicationContext属习惯命名。比如springmvc-servlet.xml、workdesk-manager.xml、workdesk-servlet.xml、applicationContext-basic.xml等\nxml里的内容多个字符间以-隔开，比如param-name，filter-mappi\n和java普通变量规范相同\n\n六、属性文件properties\n以下划线隔开：errors_zh_CN.properties，hibernate_test.properties\n '),(2,'0429','0429','小花花',2,0,'星期二','桃夭\r\n佚名 〔先秦〕\r\n\r\n桃之夭夭，灼灼其华。之子于归，宜其室家。\r\n桃之夭夭，有蕡其实。之子于归，宜其家室。\r\n桃之夭夭，其叶蓁蓁。之子于归，宜其家人。'),(3,'123456','2','小白',1,0,'星期四','赋得北方有佳人\r\n徐惠 〔唐代〕\r\n\r\n由来称独立，本自号倾城。\r\n柳叶眉间发，桃花脸上生。\r\n腕摇金钏响，步转玉环鸣。\r\n纤腰宜宝袜，红衫艳织成。\r\n悬知一顾重，别觉舞腰轻。\r\n'),(4,'123456','12','小黑',1,1,'星期三','步骤三:删除出错的文件\r\n　　bcdtoot命令执行完，退出命令窗口，点击启动修复，可以看见损坏的文件的路径，在按步骤①重新进入命令窗口，输入“del + 文件路径”命令，敲回车键，*如:del c:\\windows\\system32\\drivers\\kisboot.sys (中间有空格)*我从另外一篇文章中找到了系统引导修复的方法，链接如下：https://blog.csdn.net/qq_40570892/article/details/83540275\r\n————————————————\r\n版权声明：本文为CSDN博主「hream」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。\r\n原文链接：https://blog.csdn.net/qq_45740805/article/details/109693124'),(5,'123456','2124','小红',1,0,'星期五','凛凛岁云暮\r\n佚名 〔两汉〕\r\n\r\n凛凛岁云暮，蝼蛄夕鸣悲。\r\n凉风率已厉，游子寒无衣。\r\n锦衾遗洛浦，同袍与我违。\r\n独宿累长夜，梦想见容辉。\r\n良人惟古欢，枉驾惠前绥。\r\n愿得常巧笑，携手同车归。\r\n既来不须臾，又不处重闱。\r\n亮无晨风翼，焉能凌风飞？\r\n眄睐以适意，引领遥相睎。\r\n徙倚怀感伤，垂涕沾双扉。\r\n\r\n'),(6,'454545','54545','jj',1,0,'星期六','客从远方来\r\n佚名 〔两汉〕\r\n\r\n客从远方来，遗我一端绮。\r\n相去万余里，故人心尚尔。\r\n文采双鸳鸯，裁为合欢被。\r\n著以长相思，缘以结不解。\r\n以胶投漆中，谁能别离此？'),(45,'123456','2','小白',2,1,'星期八','采薇\r\n佚名 〔先秦〕\r\n\r\n采薇采薇，薇亦作止。曰归曰归，岁亦莫止。 靡室靡家，猃狁之故。不遑启居，猃狁之故。\r\n采薇采薇，薇亦柔止。曰归曰归，心亦忧止。 忧心烈烈，载饥载渴。我戍未定，靡使归聘。\r\n采薇采薇，薇亦刚止。曰归曰归，岁亦阳止。 王事靡盬，不遑启处。忧心孔疚，我行不来！\r\n彼尔维何？维常之华。彼路斯何？君子之车。 戎车既驾，四牡业业。岂敢定居？一月三捷。\r\n驾彼四牡，四牡骙骙。君子所依，小人所腓。 四牡翼翼，象弭鱼服。岂不日戒？猃狁孔棘！\r\n昔我往矣，杨柳依依。今我来思，雨雪霏霏。 行道迟迟，载渴载饥。我心伤悲，莫知我哀！');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
