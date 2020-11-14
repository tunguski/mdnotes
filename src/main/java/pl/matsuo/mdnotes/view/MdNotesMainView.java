package pl.matsuo.mdnotes.view;

import static j2html.TagCreator.attrs;
import static j2html.TagCreator.div;
import static j2html.TagCreator.h1;
import static j2html.TagCreator.text;

import j2html.tags.ContainerTag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.matsuo.core.util.desktop.IRequest;
import pl.matsuo.core.util.desktop.IView;
import pl.matsuo.core.util.desktop.component.FormComponents;
import pl.matsuo.core.util.desktop.component.ViewComponents;
import pl.matsuo.mdnotes.model.MdNotesModel;

@Slf4j
@RequiredArgsConstructor
public class MdNotesMainView implements IView<IRequest, MdNotesModel> {

  final ViewComponents viewComponents;
  final FormComponents formComponents;

  @Override
  public ContainerTag view(IRequest request, MdNotesModel model) {
    return viewComponents.pageTemplate(
        "Kafka instance selection",
        viewComponents.rowCol(h1("Header")),
        div(
            attrs(".row"),
            div(attrs(".col-3.border-right.bg-light"), text("bla bla")),
            div(attrs(".col-9"), text("bla bla"))));
  }
}
