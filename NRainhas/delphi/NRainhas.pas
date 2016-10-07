unit NRainhas;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, StdCtrls;

type
  TMatrix = array of array of Boolean;

  TForm1 = class(TForm)
    Button1: TButton;
    memo1: TMemo;
    edRainhas: TEdit;
    Label1: TLabel;
    procedure Button1Click(Sender: TObject);
    function ataca(tabuleiro : TMatrix; row, col : Integer):Boolean;
    procedure solucionar(tabuleiro : TMatrix; row : Integer);
    procedure FormClose(Sender: TObject; var Action: TCloseAction);
  private
    { Private declarations }
    tamTabuleiro : Integer;
    procedure print(tabuleiro : TMatrix);
  public
    { Public declarations }
  end;



var
  Form1: TForm1;


implementation

uses StrUtils;

{$R *.dfm}

procedure TForm1.Button1Click(Sender: TObject);
var tabuleiro : TMatrix;
    i, j : Integer;
begin
     Memo1.Lines.Clear;
     tamTabuleiro := StrToInt(edRainhas.Text);
     SetLength(tabuleiro, tamTabuleiro);
     for i := low(tabuleiro) to high(tabuleiro) do
          SetLength(tabuleiro[i],tamTabuleiro);
     solucionar(tabuleiro, 0);
end;

procedure TForm1.solucionar(tabuleiro : TMatrix; row : Integer);
var col : Integer;
begin
     for col := 0 to  tamTabuleiro - 1  do
     begin
          tabuleiro[row,col] := True;
          if ataca(tabuleiro, row, col) then
          begin
               if row <  tamTabuleiro -1 then
                   solucionar(tabuleiro, row + 1)
               else
               begin
                   if memo1.Lines.Count = 0 then
                      print(tabuleiro);
                   Application.ProcessMessages;
               end;
          end;
          tabuleiro[row,col] := False;
     end;
end;

function TForm1.ataca(tabuleiro : TMatrix; row, col : Integer):Boolean;
var k : Integer;
begin
     for k := 1 to row do
     begin
          if (tabuleiro[row-k, col]) or ((col - k >= 0) and tabuleiro[row-k,col-k]) or ((col+k < tamTabuleiro) and tabuleiro[row-k, col+k]) then
          begin
               Result := False;
               Exit;
          end;

     end;
     Result := True;
     Exit;

end;

procedure TForm1.print(tabuleiro: TMatrix);
var i, j, LinhaSep : Integer;
begin
     LinhaSep := 0;
     for i := 0  to tamTabuleiro -1 do
     begin
          Memo1.Lines.Add('');
          Inc(LinhaSep);
          for j := 0 to  tamTabuleiro -1 do
             memo1.Lines[LinhaSep -1] := memo1.Lines[LinhaSep - 1] + '----';
          memo1.Lines.Add('| ');
          for J := 0  to tamTabuleiro -1 do
               memo1.Lines[LinhaSep] := memo1.Lines[LinhaSep] +  IfThen(tabuleiro[i, j], 'Q', ' ') + ' | ';
          Inc(LinhaSep);

     end;
end;

procedure TForm1.FormClose(Sender: TObject; var Action: TCloseAction);
begin
     Application.Destroy;
end;

end.
