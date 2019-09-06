package com.github.kmizu.sptp

object GTDPL {
  case class GProgram(start: Nonterminal, rules: List[GRule])
  case class GRule(name: String, body: GExpression)
  sealed abstract class GExpression
  case class GuardedChoice(guard: Nonterminal, lhs: Nonterminal, rhs: Nonterminal) extends GExpression
  case class Nonterminal(name: String) extends GExpression
  case class Alphabet(value: Char) extends GExpression
  case object Failure extends GExpression
  case object Empty extends GExpression

  case class PProgram(start: Nonterminal, rules: List[PRule])
  case class PRule(name: String, body: PExpression)
  sealed abstract class PExpression extends GExpression
  case class Sequence(lhs: PExpression, rhs: PExpression) extends PExpression
  case class Choice(lhs: PExpression, rhs: PExpression) extends PExpression
  case class Repetition(body: PExpression) extends PExpression
  case class Not(body: PExpression) extends PExpression
}
