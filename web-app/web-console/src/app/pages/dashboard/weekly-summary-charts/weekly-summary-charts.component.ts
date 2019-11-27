import { AfterViewInit, Component, OnDestroy } from '@angular/core';
import { NbThemeService } from '@nebular/theme';

@Component({
  selector: 'ngx-weekly-summary-charts',
  templateUrl: 'weekly-summary-charts.html'
})
export class WeeklySummaryChartsComponent implements AfterViewInit, OnDestroy {
  options: any = {};
  themeSubscription: any;

  constructor(private theme: NbThemeService) {
  }

  ngAfterViewInit() {
    this.themeSubscription = this.theme.getJsTheme().subscribe(config => {

      const colors: any = config.variables;
      const echarts: any = config.variables.echarts;

      this.options = {
        backgroundColor: echarts.bg,
        color: [colors.danger, colors.primary, colors.info],
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b} : {c}',
        },
        legend: {
          left: 'left',
          data: ['Atendimentos', 'Receita', 'Pacientes Únicos Atendidos'],
          textStyle: {
            color: echarts.textColor,
          },
        },
        xAxis: [
          {
            type: 'category',
            data: [ 'Sexta', 'Sabado', 'Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta'],
            axisTick: {
              alignWithLabel: true,
            },
            axisLine: {
              lineStyle: {
                color: echarts.axisLineColor,
              },
            },
            axisLabel: {
              textStyle: {
                color: echarts.textColor,
              },
            },
          },
        ],
        yAxis: [
          {
            type: 'log',
            axisLine: {
              lineStyle: {
                color: echarts.axisLineColor,
              },
            },
            splitLine: {
              lineStyle: {
                color: echarts.splitLineColor,
              },
            },
            axisLabel: {
              textStyle: {
                color: echarts.textColor,
              },
            },
          },
        ],
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true,
        },
        series: [
          {
            name: 'Atendimentos',
            type: 'line',
            data: [1, 3, 1, 6, 2, 7, 1],
          },
          {
            name: 'Receita',
            type: 'line',
            data: [60, 240, 300, 660, 780, 1200, 1260],
          },
          {
            name: 'Pacientes Únicos Atendidos',
            type: 'line',
            data: [1, 3, 1, 4, 2, 5, 1],
          },
        ],
      };
    });
  }

  ngOnDestroy(): void {
    this.themeSubscription.unsubscribe();
  }
}
