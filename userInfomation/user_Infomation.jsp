

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="mainrps"> 
    <tiles:putAttribute name="title" value="SMCO :: Purchase Order" />
    <tiles:putAttribute name="js" >
        <!--libChart-->
        <!--        <script src="https://code.highcharts.com/highcharts.js"></script>
                <script src="https://code.highcharts.com/modules/exporting.js"></script>
                <script src="https://code.highcharts.com/modules/export-data.js"></script>
                <script src="https://code.highcharts.com/modules/accessibility.js"></script>-->
        <!--<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
        <script src="https://code.highcharts.com/highcharts.js"></script>-->

        <script src="/eaccount/lib/angularjs-1.6.8/ctrl/operation.js" type="text/javascript"></script>
        <script src="/eaccount/lib/angularjs-1.6.8/angular-sanitize.js" type="text/javascript"></script>
        <script type="text/javascript">
            var appangular = angular.module('storeProfileModule', ['ui.arg.utils', 'ngSanitize']);
            appangular.controller("storeProfileCtrl", function ($scope, $argutils, $compile, $timeout, $parse, $window, $filter, $sce) {

            var ctxPath = "${pageContext.request.contextPath}"; /*http://localhost:8080/eaccount*/
//            <=====================[ ModulemakeMonth ]=========================>
            let getPreviousMonthByInputNumber = function (monNum){
                let current_datetime = new Date();
                $scope.monthYear = [];
                let nowYear = current_datetime.getFullYear() + 543; //เซต ค.ศ. เป็น พ.ศ.
                let Month = current_datetime.getMonth() + 1;
                let monthTH = [
                    "มกราคม", "กุมภาพันธ์", "มีนาคม", "เมษายน", "พฤษภาคม", "มิถุนายน", 
                    "กรกฎาคม", "สิงหาคม", "กันยายน", "ตุลาคม", "พฤศจิกายน", "ธันวาคม"];
                for (let i = monNum; i >= 0; i--){
                    let mon={};
                    if (Month === 0){ //หมดมกราคมให้รีเซตเป็นเดือนธันวาคม และลดปีไป 1ปั
                        Month = 12;
                                nowYear = nowYear - 1;
                                continue;
                    }
                    mon['Month'] = Month;
                    mon['Text'] = monthTH[Month - 1];
                    mon['Year'] = nowYear;
                    $scope.monthYear.push(mon);
                    Month--;
                }
                console.log($scope.monthYear);
            };
            
             let myAlertFunction= function(titleLabel,textLabel){
                    swal({
                       title: titleLabel,
                       text: textLabel,
                       type: 'warning',
                       showCancelButton: true,
                       confirmButtonColor: '#3085d6',
                       cancelButtonColor: '#d33',
                       confirmButtonText: 'ยืนยัน',
                       cancelButtonText:'ยกเลิก'
                    })
                 } 
 
            $scope.changeMonth = function (month,year,modelMonth) {
                if(modelMonth)$scope.modelMonth = modelMonth 
                
                console.log(month,year);
                if(month&&year){
                $.ajax({
                type: 'GET',
                        async: false,
                        url: ctxPath + "/user_InfomationData.htm?month="+month+"&year="+year,
                        data: {},
                        success: function (data) {
                         let jsondata = JSON.parse(data)
                                if(jsondata.message){
                                    console.log(jsondata.message)
                                    myAlertFunction("error",jsondata.message)
                                }else{
                                    let donut = JSON.parse(data).entries.donutGraphs;
                                    let hight = JSON.parse(data).entries.hightGraphs;
                                    console.log("donut",donut,"hight",hight);
                                    pushDataIntoPiechart(donut);
//                                    pushDataIntoHightchart(hight); 
                                }
                        }
                });};
            };
            
           
           let pushDataIntoPiechart = function (dataInfomation){
               
                console.log(dataInfomation);
                $scope.userActiveMonth = dataInfomation.userActiveMonth
                $scope.userInActiveMonth = dataInfomation.userInActiveMonth
                $scope.userRegisterMonth=dataInfomation.userRegisterMonth;
                if(dataInfomation){
                    $scope.dataPie=[
                        {name:"จำนวนธุรกิจไม่เข้าใช้งาน",y:dataInfomation['userInActiveMonth'],color:'#969696'}, 
                        {name:"จำนวนธุรกิจเข้าใช้งาน",y:dataInfomation['userActiveMonth'],color:'#ec068d'}
                        
                    ];
                drawChatPie($scope.dataPie);
                $scope.$$phase|| $scope.$apply();
                }
            };
            
           let pushDataIntoHightchart = function (dataInfomation){  
              
                console.log(dataInfomation);
                if(dataInfomation){
                    let dataHightUregister=[];
                    let dataHightUactive=[];
                    let categories=[];
                  
                   for(let i=0;i<dataInfomation.length;i++){
            
                        let uregister={};
                        uregister["name"]="จำนวนธุรกิจ";
                        uregister["y"]=dataInfomation[i].uRegister;
                        dataHightUregister.unshift(uregister);
                        
                        let uactive={};
                        uactive["name"]="จำนวนธุรกิจ";
                        uactive["y"]=dataInfomation[i].uActive;
                        dataHightUactive.unshift(uactive);
                        
                        categories.unshift(paserNumberTomonthTH(dataInfomation[i].uMonth)+" "+(dataInfomation[i].uYear+543));
                   }
                   drawHightChart(dataHightUregister,dataHightUactive,categories)
                   console.log(categories);

                }
            };
              let getDateCurrentThai = function(){
                let current_datetime = new Date();
                let day=current_datetime.getDay(); //วัน อาทิตย์ - ศุกร์
                let date=current_datetime.getDate();//1-31
                let Month = current_datetime.getMonth() + 1; //เดือน
                let nowYear = current_datetime.getFullYear() + 543; //ปี เซต ค.ศ. เป็น พ.ศ.
                let hours = current_datetime.getHours(); //ชั่วโมง
                let minutes = current_datetime.getMinutes(); // นาที
                let second = current_datetime.getSeconds(); // วินาที
                
                $scope.dateThaiShow = "วันที่  "+date+" "+paserNumberTomonthTH(Month)+" "+nowYear+" "+"เวลา:"+hours+":"+minutes
                $scope.$$phase|| $scope.$apply();
                
             }
             let paserNumberTomonthTH =  function(datanumber){
                let monthTH = [
                                "มกราคม", "กุมภาพันธ์", "มีนาคม", "เมษายน", "พฤษภาคม", "มิถุนายน", 
                                "กรกฎาคม", "สิงหาคม", "กันยายน", "ตุลาคม", "พฤศจิกายน", "ธันวาคม" ];          
                return monthTH[datanumber-1];
                
             }
             let paserNumberTodateTH=  function(datanumber){
                let dateTH = [
                                "อาทิตย์", "จันทร์", "อังคาร", "พุธ", 
                                "พฤหัสบดี", "ศุกร์ ",  "เสาร์ "]; 
                                        
                return dateTH[datanumber];
             }
            

        let drawHightChart =function(dataHightUregister,dataHightUactive,categories){

         Highcharts.chart('hightChart', {
         chart: {
         type: 'spline'
         },
                 title: {
                     text: ''
                 },
//                   subtitle: {
//                   text: 'Source: WorldClimate.com'
//                   },
                 xAxis: {
//                           categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
//                                    'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
                     categories: categories
                 },
                 yAxis: {
                     title: {
                         text: 'จำนวนธุรกิจสมัครใช้งาน'
                     },
                     labels: {
                         formatter: function () {
                             return this.value + ' ';
                         }
                     }
                 },
                 tooltip: {
                     crosshairs: true,
                     shared: true
                 },
                 plotOptions: {
                     spline: {
                         marker: {
                             radius: 4,
                             lineColor: '#666666',
                             lineWidth: 1
                         }
                     }
                 },
                 colors: ['#52011b' ,'#ec068d'],
                 series: [{
                      name: 'ธุรกิจลงทะเบียนสะสม',
                      marker: { 
                         symbol: 'circle'
                      },
//                                   data: [2005.0, 2006.9, 2009.5, 2004.5, 2008.2, 2001.5, 2000.2, 2003.3, 2008.3, 2003.9, 2001.6]
                      data: dataHightUregister ? dataHightUregister : 0
                     }, {
                     
                     name: 'จำนวนธุรกิจเข้าใช้งาน',
                     marker: {
                         symbol: 'diamond'
                     },
//                                   data: [{name:"จำนวนผู้เข้าใช้งาน",y:5},{name:"จำนวนผู้เข้าใช้งาน",y:6},{name:"จำนวนผู้เข้าใช้งาน",y:8},{name:"จำนวนผู้เข้าใช้งาน",y:2}]
                     data: dataHightUactive ? dataHightUactive : 0
                 }]
         });
     }


        let drawChatPie =function(data){
            console.log("show",data);
            let pecent=data.reduce((sum,model)=>{
                return sum+model.y;
            },0);
            //setvalue to percent
//            data.forEach((model)=>{
//                model['y']=Number((model['y']/pecent*100).toFixed(2));
//            });
            console.log(data);

            var chart = Highcharts.chart('pieChart', {
            chart: {
            type: 'pie'
            },
                    plotOptions: {
                        series: {
                        allowPointSelect: true
                        },
                         pie: {
                            showInLegend: true
                        }
                    },
                    legend: {
                        enabled: true,
                        align: 'right',

                        itemWidth: 250,
                        labelFormatter: function() {
                          return this.name + '<br ><div style style=" font-size: 20px"  >'+(this.y).toFixed(0)+'</div>';
                        }
                      },
                    title: {
                    
                     text: 'จำนวนธุรกิจเข้าใช้งาน ACMO BIZ'
              
//                           useHTML: true,
//                           text: '<div>จำนวนผู้ลงทะเบียนสะสม ACMO BIZ ทั้งหมด <span style="color:#ec068d">'+$scope.userRegisterMonth+'</span> คน</div>\n\
//                                <div>จำนวนผู้เข้าใช้งาน ACMO BIZ</div>',
//                           style: {
//                               "text-align": "center"
//                           }
                     },
                    series: [{
                        dataLabels: {
                            formatter: function () {
                            // display only if larger than 1
//                            return this.y > 1 ? '<b>' + this.point.name + ':</b> ' +
//                                    this.y + '%' : null;
                                return this.y > 1 ?(this.y/pecent*100).toFixed(2)+ '%' : null;
                            }
                        },
                        innerSize: '60%',
                        name: 'จำนวน',
                        data:data ? data : 0
            //                            data:$scope.versions
                    }]
            });
            
            
            
//                function DateManagement(timeStamp){
//                    this.current_datetime = new Date(timeStamp);
//                    this.date=this.current_datetime.getDate();//1-31
//                    this.Month = this.current_datetime.getMonth() + 1; //เดือน
//                    this.nowYear = this.current_datetime.getFullYear() + 543; //ปี เซต ค.ศ. เป็น พ.ศ.
//                    this.hours = this.current_datetime.getHours(); //ชั่วโมง
//                    this.minutes = this.current_datetime.getMinutes(); // นาที
//                    this.second = this.current_datetime.getSeconds(); // วินาที
//                    this.getDate=function(){
//                        console.log(" วันที่  "+this.date+ " "+this.paserNumberTomonthTH(this.Month)+" "+this.nowYear+" "+this.hours+":"+(this.minutes<10?"0"+this.minutes : this.minutes))
//                    }
//                    this.paserNumberTomonthTH = function(datanumber){
//                        let monthTH = [
//                                    "มกราคม", "กุมภาพันธ์", "มีนาคม", "เมษายน", "พฤษภาคม", "มิถุนายน", 
//                                    "กรกฎาคม", "สิงหาคม", "กันยายน", "ตุลาคม", "พฤศจิกายน", "ธันวาคม"];
//                        return monthTH[datanumber - 1];
//
//                    }
//             }
//             new DateManagement(1581393806700).getDate()
            
    };
   //<=================[ initial value ]========================>
   pushDataIntoHightchart(${userInfomation}.entries.hightGraphs);
   pushDataIntoPiechart(${userInfomation}.entries.donutGraphs?${userInfomation}.entries.donutGraphs:0);
   getPreviousMonthByInputNumber(12);
   getDateCurrentThai();
//   setInterval(function(){ getDateCurrentThai(); }, 1000);
   
            
            });
            
        </script>
        <style>
            .borderDot{
                position: relative;
                top: 130px;
                text-align: center;
            }
            .dota {
                height: 10px;
                width: 10px;
/*                border-color: red;
                background-color: red;*/
                border-radius: 50%;
                display: inline-block;
                margin-left: 5px;
            }
            text.highcharts-credits{
                display: none;
            }
        </style>
    </tiles:putAttribute>
    <tiles:putAttribute name="body">
        <div class="ng-cloak panel panel-default row-space top-buffer" ng-app="storeProfileModule" ng-controller="storeProfileCtrl">
            <div class="col-12">
                <div class="card card-outline-primary">
                    <div class="card-header colorGray">
                        <div class="row">
                            
                            <div class="col-md-6">
                                <h5 style="margin-bottom: 0px; font-size: 1.5em">ข้อมูลผู้ใช้งานปัจจุบัน</h5>
                            </div> 
                            <div class="col-md-6">
                                <h5 id="demo" style="text-align: right; margin: 0">{{dateThaiShow}} &nbsp
                                <button type="button" class="btn borderRadius" ng-init="modelMonthRe = monthYear[0]" 
                                        ng-click="changeMonth(modelMonthRe.Month , modelMonthRe.Year,modelMonthRe)" style="text-align: center; width: 70px; padding: 0; background-color: white">รีเฟรช</button>
                                </h5>
                                 
                            </div>
                        </div>
                    </div>   
                    
                    <div class="card-body"> 

                        <div class="row">
                            
                            <div class="col-7">
                                <div class="clearfix">&nbsp;</div>
                                <div id="hightChart"></div>
                            </div>
                            
                            <div class="col-5"> 
                                <div class="clearfix">&nbsp;</div>
                                <div class="row justify-content-center">  
                                    <form class="form-inline">
                                    <div class="form-group">
                                        <label class="control-label " for="selectmonth" style=" font-size:  1.5rem">ธุรกิจเข้าใช้งานเดือน :</label>                                
                                        <select id="selectmonth" style="background-color: #5a5355;color: #f6f3f3"
                                                ng-options="(a.Text +    ' ' +    a.Year)  for a in monthYear"
                                                ng-model="modelMonth"
                                                ng-init="modelMonth = monthYear[0]" 
                                                ng-change="changeMonth(modelMonth.Month , modelMonth.Year)"
                                                >
                                        </select>                                         
                                    </div>
                                  </form>
                                </div>
                                <div class="clearfix">&nbsp;</div>
                                <div class="row">
                                    <h4 class="col-12 text-center" style="font-size: 1.2rem">จำนวนธุรกิจลงทะเบียนสะสม ACMO BIZ ทั้งหมด <span style="color:#ec068d">{{userRegisterMonth}}</span> ธุรกิจ</h4>
                                    <!--<h5 class="col-12 text-center" style="font-size: 18px">จำนวนธุรกิจเข้าใช้งาน ACMO BIZ</h5>-->
                                </div>
                                <div id="pieChart"></div>
                                <div class="row">

<!--                                    <div class="col-5">
                                        <h1 style="text-align: right; color:#ec068d;">{{userActiveMonth}}</h1>
                                        <div style="font-size: small; text-align: right;">
                                            <em class="fa fa-circle" style="color:#ec068d;"></em>
                                            จำนวนธุรกิจเข้าใช้งาน
                                        </div>
                                    </div>
                                    <div class="col-2"><h1 style="text-align: center;">/</h1></div>
                                    <div class="col-5">
                                        <h1>{{userInActiveMonth}}</h1>
                                        <div style="font-size: small;">
                                            <em class="fa fa-circle" style="color:#969696;"></em>
                                            จำนวนธุรกิจไม่เข้าใช้งาน
                                        </div>
                                    </div>-->
                                    <div class="col-1"></div>
                                </div>
                            </div>
                        </div>
                        </div>
                    </div>
                    </div>
                </div>
            </tiles:putAttribute>
        </tiles:insertDefinition>
