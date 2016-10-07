object Form1: TForm1
  Left = 474
  Top = 100
  Width = 851
  Height = 474
  Caption = 'Form1'
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'MS Sans Serif'
  Font.Style = []
  OldCreateOrder = False
  OnClose = FormClose
  PixelsPerInch = 96
  TextHeight = 13
  object Label1: TLabel
    Left = 8
    Top = 16
    Width = 82
    Height = 13
    Caption = 'N. de Rainhas'
    Font.Charset = DEFAULT_CHARSET
    Font.Color = clWindowText
    Font.Height = -11
    Font.Name = 'MS Sans Serif'
    Font.Style = [fsBold]
    ParentFont = False
  end
  object Button1: TButton
    Left = 88
    Top = 32
    Width = 75
    Height = 25
    Caption = 'Solu'#231#227'o'
    TabOrder = 0
    OnClick = Button1Click
  end
  object memo1: TMemo
    Left = 171
    Top = 0
    Width = 664
    Height = 436
    Align = alRight
    Font.Charset = ANSI_CHARSET
    Font.Color = clWindowText
    Font.Height = -11
    Font.Name = 'Consolas'
    Font.Style = []
    Lines.Strings = (
      '')
    ParentFont = False
    ScrollBars = ssBoth
    TabOrder = 1
  end
  object edRainhas: TEdit
    Left = 8
    Top = 32
    Width = 41
    Height = 21
    TabOrder = 2
  end
end
