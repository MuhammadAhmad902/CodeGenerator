package smWithHistory;

import com.google.common.base.Objects;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import smWithHistory.Action;
import smWithHistory.LabelTransition;
import smWithHistory.Pseudostate;
import smWithHistory.PseudostateKind;
import smWithHistory.State;
import smWithHistory.Statemachine;
import smWithHistory.Transition;
import smWithHistory.Vertex;

@SuppressWarnings("all")
public class FanTemplateGenerator {
  private final String pkg = "package fanStatemachine;";
  
  private final String path = "src/fanStatemachine";
  
  private boolean file = new File(this.path).mkdir();
  
  public void getTestMachine(final Statemachine sm) {
    Vertex singleState = null;
    Vertex[] _states = sm.getStates();
    for (final Vertex st : _states) {
      if (((st instanceof Pseudostate) && Objects.equal(((Pseudostate) st).getKind(), PseudostateKind.Final))) {
        InputOutput.<String>println("Do nothing!!");
      } else {
        singleState = st;
        this.getSingleState(st);
      }
    }
    this.machineContext(singleState);
    this.superStateClass(singleState);
  }
  
  public void getSingleState(final Vertex vertex) {
    Transition[] _outgoings = vertex.getOutgoings();
    for (final Transition tr : _outgoings) {
      {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(this.pkg);
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        _builder.append("public class ");
        {
          if (((tr.getSource() instanceof Pseudostate) && Objects.equal(((Pseudostate) tr.getSource()).getKind(), PseudostateKind.Initial))) {
            _builder.append("Off");
          } else {
            Vertex _source = tr.getSource();
            if ((_source instanceof State)) {
              Vertex _source_1 = tr.getSource();
              String _stateName = ((State) _source_1).getStateName();
              _builder.append(_stateName);
            }
          }
        }
        _builder.append(" extends State {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("public void ");
        {
          if ((tr instanceof LabelTransition)) {
            String _actionName = ((LabelTransition) tr).getAction().getActionName();
            _builder.append(_actionName, "\t");
          } else {
            _builder.append("goNext");
          }
        }
        _builder.append("(MachineContext ctx){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("ctx.setState(");
        {
          Vertex _target = tr.getTarget();
          if ((_target instanceof Pseudostate)) {
            _builder.append("new Off()");
          } else {
            Vertex _target_1 = tr.getTarget();
            if ((_target_1 instanceof State)) {
              _builder.append("new ");
              Vertex _target_2 = tr.getTarget();
              String _stateName_1 = ((State) _target_2).getStateName();
              _builder.append(_stateName_1, "\t\t");
              _builder.append("()");
            }
          }
        }
        _builder.append(");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("System.out.println(\"");
        String _transitionStatus = tr.getTransitionStatus();
        _builder.append(_transitionStatus, "\t\t");
        _builder.append("\");");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        String data = _builder.toString();
        String filename = "";
        Vertex _source_2 = tr.getSource();
        if ((_source_2 instanceof Pseudostate)) {
          filename = "Off";
        } else {
          Vertex _source_3 = tr.getSource();
          filename = ((State) _source_3).getStateName();
        }
        this.filewriter(filename, data);
      }
    }
  }
  
  public void superStateClass(final Vertex vertex) {
    Action getActractAction = null;
    Transition[] _outgoings = vertex.getOutgoings();
    for (final Transition tr : _outgoings) {
      if ((tr instanceof LabelTransition)) {
        getActractAction = ((LabelTransition)tr).getAction();
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(this.pkg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public abstract class State{");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public abstract void ");
    {
      if ((getActractAction != null)) {
        String _actionName = getActractAction.getActionName();
        _builder.append(_actionName, "\t");
      } else {
        _builder.append("goNext");
      }
    }
    _builder.append("(MachineContext ctx);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    String data = _builder.toString();
    this.filewriter("State", data);
  }
  
  public void machineContext(final Vertex vertex) {
    Action getActractAction = null;
    Transition[] _outgoings = vertex.getOutgoings();
    for (final Transition tr : _outgoings) {
      if ((tr instanceof LabelTransition)) {
        getActractAction = ((LabelTransition)tr).getAction();
      }
    }
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(this.pkg);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class MachineContext {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private State current;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public MachineContext() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("current = new Off();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void setState(State state) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("current = state;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public State getState() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return this.current;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void run() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("current.");
    {
      if ((getActractAction != null)) {
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        String _actionName = getActractAction.getActionName();
        _builder.append(_actionName, "\t\t");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
      } else {
        _builder.append("goNext");
      }
    }
    _builder.append("(this);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String data = _builder.toString();
    this.filewriter("MachineContext", data);
  }
  
  public void filewriter(final String fileName, final String data) {
    try {
      String _concat = fileName.concat(".java");
      File _file = new File(this.path, _concat);
      FileWriter _fileWriter = new FileWriter(_file);
      BufferedWriter bw = new BufferedWriter(_fileWriter);
      bw.write(data);
      bw.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
