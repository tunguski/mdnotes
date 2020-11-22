package pl.matsuo.mdnotes.view;

import static j2html.TagCreator.b;
import static j2html.TagCreator.div;
import static j2html.TagCreator.span;

import j2html.tags.ContainerTag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.matsuo.core.util.desktop.mvc.IRequest;
import pl.matsuo.core.util.desktop.mvc.IView;
import pl.matsuo.mdnotes.component.ViewTemplate;
import pl.matsuo.mdnotes.model.MdNotesModel;

@Slf4j
@RequiredArgsConstructor
public class NoPageFoundView implements IView<IRequest, MdNotesModel> {

  final ViewTemplate template;

  @Override
  public ContainerTag view(IRequest request, MdNotesModel model) {
    return template.view(request, model, div(span("Page not found: "), b(request.getPath())));
  }
}
